public class SpecialIceCreamOrder extends IceCreamOrder {

    private double specialFee;

    public SpecialIceCreamOrder(String customerName, int scoopCount,
                                double pricePerScoop, boolean paid,
                                HolderType holderType, String[] flavors,
                                double specialFee) {

        super(customerName, scoopCount, pricePerScoop, paid, holderType, flavors);

        if (specialFee < 0) {
            this.specialFee = 0;
        } else {
            this.specialFee = specialFee;
        }
    }

    @Override
    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double total;

        if (subtotal >= 20.00) {
            total = subtotal - (subtotal * 0.10);
        } else {
            total = subtotal;
        }

        total += specialFee;

        return total;
    }
}