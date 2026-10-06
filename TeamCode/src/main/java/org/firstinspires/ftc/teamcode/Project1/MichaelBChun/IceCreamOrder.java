abstract class IceCreamOrder {
    private String customerName;
    private int scoopCount;
    private double pricePerScoop;
    private boolean paid;
    private HolderType holderType;
    private String[] flavors;

    IceCreamOrder(String customerName, int scoopCount, double pricePerScoop, boolean paid, HolderType holderType, String[] flavors) {
    this.customerName = customerName;
    this.scoopCount = scoopCount;
    this.pricePerScoop = pricePerScoop;
    this.paid = paid;
    this.holderType = holderType;
    this.flavors = flavors;

    if (scoopCount < 0) {
        this.scoopCount = 0;
    }
    if (pricePerScoop < 0) {
        this.pricePerScoop = 0;
    }
    }

    String getCustomerName() {
        return customerName;
    }

    int getScoopCount() {
        return scoopCount;
    }

    boolean getPaid() {
        return paid;
    }

    HolderType getHolderType() {
        return holderType;
    }

    void setScoopCount(int scoopCount) {
        if (scoopCount >= 0) {
            this.scoopCount = scoopCount;
        }
    }

    void setPricePerScoop(double PricePerScoop) {
        if (pricePerScoop > 0) {
            this.pricePerScoop = pricePerScoop;
        }
    }

    void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double calculateSubtotal() {
        double subTotalProduct = scoopCount * pricePerScoop;
        return subTotalProduct;
    }

    public int estimatePreparationMinutes() {
        double preparationMinutesProduct = scoopCount * 1.5;
        int intPrepMinProd = (int) preparationMinutesProduct;
        return intPrepMinProd;
    }

    public String getOrderMessage() {
        if (scoopCount == 0) {
            return "The order is empty";
        } else if (scoopCount > 0 && !paid) {
            return "Payment is required";
        } else {
            return "The order is ready to prepare";
        }
    }

    public String getContainerType() {
        switch(holderType) {
            case CUP:
                return "Cup";
            case SUGAR_CONE:
                return "Sugar cone";
            case WAFFLE_CONE:
                return "Waffle cone";
            default: // Visual Studio Code on Windows said that this section was needed. I wrote my code on the app to check for mistakes as I went then copied and pasted it here.
                return ""; 
        }
    }

    public boolean hasFlavor(String targetFlavor) {
        boolean match = false;
        for (String flavor : flavors) {
            if (flavor == targetFlavor) {
                match = true;
                break;
            }
        }
        return match;
    }
    
    public int countValidFlavors() {
        int flavorCount = 0;
        for (String flavor : flavors) {
            if (flavor == null) {
                continue;
            } else {
                flavorCount ++;
            }
        }
        return flavorCount;
    }

    public int prepareScoops() {
        int counter = 0;
        while (counter != scoopCount) {
            counter ++;
        }
        return counter;
    }

    public void addScoop(String Flavor) {
        scoopCount ++;
    }

    public void addScoop(String Flavor, int quantity) {
        if (quantity > 0) {
            scoopCount += quantity;
        }
    }

    public abstract double calculateTotal();
    }