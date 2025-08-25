package de.tum.in.ase.eist.ecommerce;

public class ECommerceFacade {

    private AdvertisementController advertisementController;
    private OrderController orderController;

    private ShippingController shippingController;
    //

    public ECommerceFacade() {
        advertisementController = new AdvertisementController();
        orderController = new OrderController();
        shippingController = new ShippingController();
    }

    public void processOrder(Order order) {
        orderController.processOrder(order);
    }

    public void processOrder(Order order, String phoneNumber) {
        orderController.processOrder(order, phoneNumber);
    }

    public Order retrieveLatestOrder(int id) {
        return orderController.retrieveLatestOrder(id);
    }

    public void playAdvertisement(int ageRestriction) {
        advertisementController.playAdvertisement(ageRestriction);
    }

    public void shipOrder(Order order, String address) {
        order.setShipping(shippingController.createShipping(address));
        shippingController.shipOrder(order);
    }

}
