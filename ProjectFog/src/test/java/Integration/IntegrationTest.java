package Integration;

import FunctionLayer.Calculation.CarportCalculator;
import FunctionLayer.Exceptions.FogException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class IntegrationTest {

    @Test
    public void CalcCarport() throws FogException {
        // Arrange:
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 0, false, false, 0, 0, "Tagpap");
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(4173.56, cc.getTotalPrice(), 0.005);
        assertEquals(60, cc.getProductList().size());
    }
}
