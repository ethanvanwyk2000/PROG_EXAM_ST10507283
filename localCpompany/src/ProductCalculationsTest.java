import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductCalculationsTest {

    @Test
    void getVat() {

        ProductCalculations calc = new ProductCalculations("Joe Bloggs", "Cozy Night Monarch", 0.0, 0.0, 0.0, 3500);


        double actualVat = calc.GetVat();
        double expectedVat = 525.0;


        assertEquals(expectedVat, actualVat, 0.001);
    }

    @Test
    void getTotal() {

        ProductCalculations calc = new ProductCalculations("Joe Bloggs", "Cozy Night Monarch", 0.0, 0.0, 0.0, 3500);

        double actualTotal = calc.GetTotal();
        double expectedTotal = 4200.0;


        assertEquals(expectedTotal, actualTotal, 0.001);
    }
}
