class SpecialIceCreamOrder extends IceCreamOrder{
    private double specialFee;

    public SpecialIceCreamOrder(String customerName, int scoopCount, double pricePerScoop, boolean paid, HolderType holderType, String[] flavors, double specialFee) {
        super(customerName, scoopCount, specialFee, paid, holderType, flavors);
        
        this.specialFee = specialFee;
        if (specialFee < 0.0) {
            this.specialFee = 0.0;
        }
    }

    @Override public double calculateTotal() {
        double subtotal = calculateSubtotal();
        if (subtotal >= 20.0) {
            subtotal *= 0.9;
        }
        double total = calculateSubtotal() + specialFee;
        return total;
    }
}