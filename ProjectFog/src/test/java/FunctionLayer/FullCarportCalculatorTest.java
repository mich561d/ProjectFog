package FunctionLayer;

import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Calculation.CarportCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael & Christian
 */
public class FullCarportCalculatorTest {

    //IntegrationTest
    @Test
    public void TestIntegrationOfCarportProductListSize() throws FogException {
        // Arrange:
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 0, false, false, 0, 0, "Tagpap");
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(60, cc.getProductList().size());
    }

    @Test
    public void TestIntegrationOfCarportTotalPrice() throws FogException {
        // Arrange:
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 0, false, false, 0, 0, "Tagpap");
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(4173.56, cc.getTotalPrice(), 0.005);
    }

    // Full calculations
    @Test
    public void CalcFullCarportProductListSize() throws FogException {
        // Arrange:
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 20, true, true, 100, 210, "Tagpap");
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(177, cc.getProductList().size());
    }

    @Test
    public void CalcFullCarportTotalPrice() throws FogException {
        // Arrange:
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 20, true, true, 100, 210, "Tagpap");
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(9644.22, cc.getTotalPrice(), 0.005);
    }
    
        @Test
    public void CalcFullCarportListToMap() throws FogException {
        // Arrange:
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 20, true, true, 100, 210, "Tagpap");
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(12, cc.getProductMap().size());
    }
}
