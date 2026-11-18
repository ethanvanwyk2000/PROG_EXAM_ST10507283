import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int expected = 153;
        int actualTotal = product.GetTotalProductSold();

        assertEquals(expected, actualTotal);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        double expected = 17.0;
        double actualAverage = product.GetAverageProductSold();

        assertEquals(expected, actualAverage, 0.001);
    }

    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        assertEquals("Sealy phuket mattress", product.GetMostPopularProduct());
    }
}