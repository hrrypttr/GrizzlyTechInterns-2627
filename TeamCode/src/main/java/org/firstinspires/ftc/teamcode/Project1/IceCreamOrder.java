abstract class IceCreamOrder {

    private String customerName;
    private int scoopCount;
    private double pricePerScoop;
    private boolean paid;
    private HolderType holderType;
    private String[] flavors;

    public IceCreamOrder (String customerName, int scoopCount, double pricePerScoop, boolean paid, HolderType holderType, String[] flavors) {
        this.customerName = customerName;
        this.paid = paid;
        this.holderType = holderType;
        this.flavors = flavors;
        if(scoopCount < 0) {
            this.scoopCount = 0;
        } else {
            this.scoopCount = scoopCount;
        }
        if(pricePerScoop < 0) {
            this.pricePerScoop = 0;
        } else {
            this.pricePerScoop = pricePerScoop;
        }
    }

    public String getCustomerName () {
        return customerName;
    }

    public int getScoopCount () {
        return scoopCount;
    }

    public boolean getPaid () {
        return paid;
    }

    public HolderType getHolderType () {
        return holderType;
    }

    public void setScoopCount(int scoopCount) {
        if (scoopCount >= 0) {
            this.scoopCount = scoopCount;
        }
    }

    public void setPricePerScoop(double pricePerScoop) {
        if (pricePerScoop >= 0) {
            this.pricePerScoop = pricePerScoop;
        }
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double calculateSubtotal() {
        double subTotal;
        subTotal = scoopCount * pricePerScoop;
        return subTotal;
    }

    public int estimatePreparationMinutes() {
        double estimate;
        estimate = scoopCount * 1.5;
        //rounded to the nearest whole int
        estimate += 0.5;
        return (int) estimate;
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
        switch (holderType) {
          case CUP:
              return "Cup";
          case WAFFLE_CONE:
              return "Waffle cone";
          case SUGAR_CONE:
              return "Sugar cone";
        }
        return "";
    }

    public boolean hasFlavor(String targetFlavor) {
        boolean correct = false;
        for (String flavor: flavors) {
            if(flavor.equals(targetFlavor)) {
                correct = true;
                break;
            }
        }
        return correct;
    }

    public int countValidFlavors() {
        int count = 0;
        for(String flavor: flavors) {
            if (flavor == null) {
                continue;
            } else {
                count ++;
            }
        }
        return count;
    }

    public int prepareScoops() {
        int count = 0;
        while (count < scoopCount) {
            count ++;
        }
        return count;
    }

    public void addScoop(String flavor) {
        boolean full = true;
        String[] temp;
        scoopCount ++;
        for(int i = 0; i < flavors.length; i ++) {
            if (flavors[i] == null) {
                flavors[i] = flavor;
                full = false;
                break;
            }
        }
        if(full) {
            temp = flavors;
            flavors = new String[flavors.length + 1];
            for (int i = 0; i < temp.length; i ++) {
                flavors[i] = temp[i];
            }
            flavors[flavors.length-1] = flavor;
        }
    }

    public void addScoop(String flavor, int quantity) {
        boolean full = true;
        String[] temp;
        if (quantity  > 0);
        scoopCount += quantity;
        for(int i = 0; i < flavors.length; i ++) {
            if (flavors[i] == null) {
                flavors[i] = flavor;
                full = false;
                break;
            }
        }
        if(full) {
            temp = flavors;
            flavors = new String[flavors.length + 1];
            for (int i = 0; i < temp.length; i ++) {
                flavors[i] = temp[i];
            }
            flavors[flavors.length-1] = flavor;
        }
    }

    public abstract double calculateTotal();
}