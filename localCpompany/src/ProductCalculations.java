public class ProductCalculations implements IProductCalculations {
    private String customerName;
    private String productName;
    private double VATAmount;
    private double commissionPercentage;
    private double total;
    private int price;

    public ProductCalculations(String customerName, String productName, double VATAmount, double commissionPercentage, double total, int price) {
        this.customerName = customerName;
        this.productName = productName;
        this.VATAmount = VATAmount;
        this.commissionPercentage = commissionPercentage;
        this.total = total;
        this.price = price;
    }

    @Override
    public double GetVat() {
        this.VATAmount = this.price * 0.15;
        return this.VATAmount;
    }

    @Override
    public double GetCommission() {
        this.commissionPercentage = this.price * 0.05;
        return this.commissionPercentage;
    }

    @Override
    public double GetTotal() {
        this.total = this.price + GetVat() + GetCommission();
        return this.total;
    }
}
