public abstract class IceCreamOrder {

    private String customerName;
    private int scoopCount;
    private double pricePerScoop;
    private boolean paid;
    private HolderType holderType;
    private String[] flavors;



    public IceCreamOrder(String customerName, int scoopCount,
                         double pricePerScoop, boolean paid,
                         HolderType holderType, String[] flavors) {

        this.customerName = customerName;

        if (scoopCount < 0) {
            this.scoopCount = 0;
        } else {
            this.scoopCount = scoopCount;
        }

        if (pricePerScoop < 0) {
            this.pricePerScoop = 0;
        } else {
            this.pricePerScoop = pricePerScoop;
        }

        this.paid = paid;
        this.holderType = holderType;
        this.flavors = flavors;
    }




    public String getCustomerName() {
        return customerName;
    }

    public int getScoopCount() {
        return scoopCount;
    }

    public boolean getPaid() {
        return paid;
    }

    public HolderType getHolderType() {
        return holderType;
    }



    public void setScoopCount(int scoopCount) {
        if (scoopCount >= 0) {
            this.scoopCount = scoopCount;
        }
    }

    public void setPricePerScoop(double pricePerScoop) {
        if (pricePerScoop > 0) {
            this.pricePerScoop = pricePerScoop;
        }
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double calculateSubtotal() {
        double subtotal = scoopCount * pricePerScoop;
        return subtotal;
    }

    public int estimatePreparationMinutes() {
        double estimate = scoopCount * 1.5;
        int minutes = (int) estimate;
        return minutes;
    }

    public String getOrderMessage() {
        if (scoopCount == 0) {
            return "The order is empty.";
        } else if (scoopCount > 0 && paid == false) {
            return "Payment is required.";
        } else {
            return "The order is ready to prepare.";
        }
    }

    public String getContainerType() {
        switch (holderType) {
            case CUP:
                return "Cup";
            case SUGAR_CONE:
                return "Sugar cone";
            case WAFFLE_CONE:
                return "Waffle cone";
            default:
                return "Unknown";
        }
    }

    public boolean hasFlavor(String targetFlavor) {
        boolean found = false;

        for (int i = 0; i < flavors.length; i++) {
            if (flavors[i] != null && flavors[i].equals(targetFlavor)) {
                found = true;
                break;
            }
        }

        return found;
    }

    public int countValidFlavors() {
        int count = 0;

        for (int i = 0; i < flavors.length; i++) {
            if (flavors[i] == null || flavors[i].isEmpty()) {
                continue;
            }

            count++;
        }

        return count;
    }

    public int prepareScoops() {
        int counter = 0;

        while (counter < scoopCount) {
            counter++;
        }

        return counter;
    }

    public void addScoop(String flavor) {
        scoopCount++;

        for (int i = 0; i < flavors.length; i++) {
            if (flavors[i] == null || flavors[i].isEmpty()) {
                flavors[i] = flavor;
                break;
            }
        }
    }

    public void addScoop(String flavor, int quantity) {
        if (quantity > 0) {
            scoopCount += quantity;

            for (int i = 0; i < flavors.length; i++) {
                if (flavors[i] == null || flavors[i].isEmpty()) {
                    flavors[i] = flavor;
                    break;
                }
            }
        }
    }

    public abstract double calculateTotal();
}