public class PrintProduct extends Product{
    public void printProduct(){
        Product product = new Product();

        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("*".repeat(35));
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductSold());
        System.out.println("AVERAGE PRODUCT SALES: " + product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
