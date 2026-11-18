public class Product implements IProduct{

    String [] mattressNames = {"Night Monarch Mattress", "Barbados mattress","Sealy phuket mattress"};
    int Size = 3;
    int[][] sales = new int[Size][Size];
    String []months = {"month 1","month 2","month 3"};


    @Override
    public int GetTotalProductSold() {
        int total = 0;
        for (int[] sale : sales) {
            for (int j = 0; j < sale.length; j++) {
                total += sale[j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int totalElements = sales.length * sales[0].length;
        return (double) GetTotalProductSold() / totalElements;
    }


    @Override
    public String GetMostPopularProduct() {
        String mostPopular = "";
        int popularSales = -1;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > popularSales) {
                    popularSales = sales[i][j];
                    mostPopular = mattressNames[i];
                }
            }
        }
        return mostPopular;
    }
}

