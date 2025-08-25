package de.tum.in.ase.eist;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        detectDeadlock(new SwimmingPool());
    }

    public static void detectDeadlock(SwimmingPool swimmingPool) {
        Thread thread1 = new Thread(() -> {
            Swimmer swimmer1 = new Swimmer();
            swimmer1.goToSwimmingPool(swimmingPool, SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER);
        });

        Thread thread2 = new Thread(() -> {
            Swimmer swimmer2 = new Swimmer();
            swimmer2.goToSwimmingPool(swimmingPool, SwimmingPoolActionOrder.LOCKER_BEFORE_CHANGING_ROOM);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Blocking...");
    }
}
