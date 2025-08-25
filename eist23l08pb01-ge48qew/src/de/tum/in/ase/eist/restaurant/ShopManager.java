package de.tum.in.ase.eist.restaurant;

public class ShopManager {

    private static String name = "Aniruddh";

    private static int id = 1;

    private FoodPalace foodPalace;

    public ShopManager() {
        this.foodPalace = new FoodPalace(new SaladBar(), new Curry(), new IceCreamStand());
    }

    public void testSalad() {
        foodPalace.makeSalad();
    }

    public void testCurry() {
        foodPalace.makeCurry();
    }

    public void testIceCream() {
        foodPalace.makeIceCream();
    }

    public static void main(String[] args) {
        ShopManager shopManager = new ShopManager();
        shopManager.testSalad();
        shopManager.testCurry();
        shopManager.testIceCream();
    }

}
