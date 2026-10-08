public class StoreSimulation {

    public void simulateDay() {

        String[] flavors = {
            "Vanilla",
            "Chocolate",
            "Strawberry",
            "Mint",
            "Cookie Dough"
        };

        SpecialIceCreamOrder specialOrder =
            new SpecialIceCreamOrder(
                "John",
                4,
                6.00,
                false,
                HolderType.WAFFLE_CONE,
                flavors,
                2.00
            );


        IceCreamOrder order = specialOrder;
        double total = order.calculateTotal();


        order.addScoop("Vanilla");
        order.addScoop("Chocolate", 2);

        String message = order.getOrderMessage();
        String container = order.getContainerType();
        boolean hasVanilla = order.hasFlavor("Vanilla");
        int validFlavors = order.countValidFlavors();
        int preparedScoops = order.prepareScoops();
        int preparationTime = order.estimatePreparationMinutes();
        String customer = order.getCustomerName();


        order.setScoopCount(5);

        System.out.println("Customer: " + customer);
        System.out.println("Total: $" + total);
        System.out.println(message);
        System.out.println("Container: " + container);
        System.out.println("Has vanilla: " + hasVanilla);
        System.out.println("Valid flavors: " + validFlavors);
        System.out.println("Prepared scoops: " + preparedScoops);
        System.out.println("Preparation time: " + preparationTime);
    }
}