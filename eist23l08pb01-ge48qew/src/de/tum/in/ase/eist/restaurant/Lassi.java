package de.tum.in.ase.eist.restaurant;

public class Lassi extends Dishes {

    private static String name = "Lassi";

    public void makeLassi() {
        System.out.println("Your Lassi (Indian Drink) has been made!");
    }

    public void serveLassi() {
        if(!Table.currentTableRepresentation.equals(Table.cleanTableRepresentation)) {
            Table.cleanTable();
        }
        if(!Table.areCandlesLighted) {
            Table.lightCandles();
        }
        if(Table.waterLevel <= 0.5 ) {
            Table.fillWater();
        }
        Table.readDaysMenu();
        Table.askForFurtherRequests();
    }

    public String getName() {
        return name;
    }
}
