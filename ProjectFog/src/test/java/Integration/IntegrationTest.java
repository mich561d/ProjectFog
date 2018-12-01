package Integration;

import FunctionLayer.Calculation.CarportCalculator;
import FunctionLayer.FogException;
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
        CarportCalculator cc = new CarportCalculator(240, 240, 200, 0, false, false, 0, 0);
        // Act:
        cc.calcCarport();
        // Assert:
        assertEquals(4025.66, cc.getTotalPrice(), 0.005);
        assertEquals(58, cc.getProductList().size());
    }
}
