package de.tum.in.ase.eist;

import java.util.concurrent.locks.ReentrantLock;

public class SwimmingPool {
    private final ChangingRoom changingRoom;
    private final Locker locker;
    private int totalVisitors;
    private final ReentrantLock totalVisitorsLock;

    public SwimmingPool() {
        this.changingRoom = new ChangingRoom();
        this.locker = new Locker();
        this.totalVisitors = 0;
        this.totalVisitorsLock = new ReentrantLock();
    }

    public void handleEntryRequest(Swimmer swimmer, SwimmingPoolActionOrder order) {
        switch (order) {
            case CHANGING_ROOM_BEFORE_LOCKER -> {
                changingRoom.acquireKey(swimmer);
                locker.storeClothes(swimmer);

                System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                locker.retrieveClothes();
                changingRoom.releaseKey();
            }
            case LOCKER_BEFORE_CHANGING_ROOM -> {
                locker.storeClothes(swimmer);
                changingRoom.acquireKey(swimmer);

                System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                changingRoom.releaseKey();
                locker.retrieveClothes();
            }
        }
        totalVisitorsLock.lock();
        totalVisitors++;
        totalVisitorsLock.unlock();
    }

    public void handleEntryRequestDeadlockFree(Swimmer swimmer, SwimmingPoolActionOrder order) {
        synchronized (this) {
            if (order == SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER) {
                if (changingRoom.getMutex().tryLock()) {
                    if (locker.getMutex().tryLock()) {
                        changingRoom.acquireKey(swimmer);
                        locker.storeClothes(swimmer);
                        System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());
                        locker.retrieveClothes();
                        changingRoom.releaseKey();
                        locker.getMutex().unlock();

                        totalVisitorsLock.lock();
                        totalVisitors++;
                        totalVisitorsLock.unlock();
                    } else {
                        System.out.printf("Swimmer %d entry request rejected. Could not acquire locker.\n", swimmer.getId());
                        changingRoom.getMutex().unlock();
                    }
                } else {
                    System.out.printf("Swimmer %d entry request rejected. Could not acquire changing room.\n", swimmer.getId());
                }
            } else if (order == SwimmingPoolActionOrder.LOCKER_BEFORE_CHANGING_ROOM) {
                if (locker.getMutex().tryLock()) {
                    if (changingRoom.getMutex().tryLock()) {
                        locker.storeClothes(swimmer);
                        changingRoom.acquireKey(swimmer);
                        System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());
                        changingRoom.releaseKey();
                        locker.retrieveClothes();
                        changingRoom.getMutex().unlock();

                        totalVisitorsLock.lock();
                        totalVisitors++;
                        totalVisitorsLock.unlock();
                    } else {
                        System.out.printf("Swimmer %d entry request rejected. Could not acquire changing room.\n", swimmer.getId());
                        locker.getMutex().unlock();
                    }
                } else {
                    System.out.printf("Swimmer %d entry request rejected. Could not acquire locker.\n", swimmer.getId());
                }
            } else {
                System.out.printf("Swimmer %d entry request rejected. Invalid order: %s\n", swimmer.getId(), order);
            }
        }
        //handleEntryRequest(swimmer, order);
    }


    public int getTotalVisitors() {
        return this.totalVisitors;
    }
}
