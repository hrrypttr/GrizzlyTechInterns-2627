public class StoreSimulation {

    public void simulateDay() {
        String[] flavors = {"Vanilla", "Chocolate", "Mint-chip", "Strawberry", "Birthday Cake"};
        HolderType type = HolderType.WAFFLE_CONE;
        SpecialIceCreamOrder order1 = new SpecialIceCreamOrder ("Bob", 2, 4.65, false, type, flavors, 3.42);
        IceCreamOrder order2 = order1;
        order2.calculateTotal();
        order1.addScoop("Banana");
        order1.addScoop("Caramel", 3);
        System.out.println(order1.getOrderMessage());
        System.out.println(order1.getContainerType());
        System.out.println(order1.hasFlavor("Banana"));
        System.out.println(order1.hasFlavor("nothing"));
        System.out.println(order1.countValidFlavors());
        System.out.println(order1.prepareScoops());
        System.out.println(order1.estimatePreparationMinutes());
        System.out.println(order1.getScoopCount());
        order1.setPaid(true);
    }
}