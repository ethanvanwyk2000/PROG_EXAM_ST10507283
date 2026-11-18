import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        for (int i = 0; i < product.sales.length; i++) {
            for (int j = 0; j < product.sales[i].length; j++) {
                System.out.print("Enter number of sales for " + product.months[j] + " for " + product.mattressNames[i] + ": ");
                product.sales[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        PrintProduct product1 = new PrintProduct();
        product1.printProduct();
    }
}
