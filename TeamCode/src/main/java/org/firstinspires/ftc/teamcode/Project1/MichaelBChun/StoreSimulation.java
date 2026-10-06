class StoreSimulation {
    public void simulateDay() {
        String[] flavorNames = {"Chocolate", "Vanilla", "Strawberry", "Pistachio", "Mint"};

        String[] specialOrderFlavors = {"Strawberry", "Chocolate"};
        SpecialIceCreamOrder specialOrder = new SpecialIceCreamOrder("Michael", 2, 2.00, true, HolderType.WAFFLE_CONE, specialOrderFlavors, 1.00);

        IceCreamOrder order = specialOrder;

        order.calculateTotal();

        order.addScoop("Strawberry");
        order.addScoop("Strawberry", 2);

        order.getOrderMessage();
        order.getContainerType();
        order.hasFlavor("Strawberry");
        order.countValidFlavors();
        order.prepareScoops();
        order.estimatePreparationMinutes();

        order.getScoopCount();
        order.setScoopCount(2);
    }
}