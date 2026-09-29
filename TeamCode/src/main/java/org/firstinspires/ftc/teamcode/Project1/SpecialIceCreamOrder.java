public class SpecialIceCreamOrder extends IceCreamOrder {
    
    double specialFee;

    public SpecialIceCreamOrder (String customerName, int scoopCount, double pricePerScoop, boolean paid, HolderType holderType, String[] flavors, double specialFee){
        super(customerName, scoopCount, pricePerScoop, paid, holderType, flavors);
        if (specialFee < 0) {
            this.specialFee = 0;
        } else {
            this.specialFee = specialFee;
        }
    }

    
    @Override public double calculateTotal () {
        double num = calculateSubtotal();
        if (num > 20) {
            num *= 0.9;
        }
        num += specialFee;
        return num;
    }
}