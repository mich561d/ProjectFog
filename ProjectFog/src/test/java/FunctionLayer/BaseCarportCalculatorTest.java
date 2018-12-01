package FunctionLayer;

import FunctionLayer.Calculation.Base.BasePoleCalculator;
import FunctionLayer.Calculation.Base.BaseRaftCalculator;
import FunctionLayer.Entities.Part;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class BaseCarportCalculatorTest {

    // Test with input under breakpoint
    @Test
    public void CalcPolesWithSmallCarport() throws FogException {
        // Arrange:
        BasePoleCalculator bpc = new BasePoleCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = bpc.calcPoles(list, 240, 240, 200);
        // Assert:
        assertEquals(6, list.size());
    }

    @Test
    public void CalcRaftsWithSmallCarport() throws FogException {
        // Arrange:
        BaseRaftCalculator brc = new BaseRaftCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = brc.calcRafts(list, 240, 240);
        // Assert:
        assertEquals(7, list.size());
    }

    // Test with input at breakpoint
    @Test
    public void CalcPolesWithMediumCarport() throws FogException {
        // Arrange:
        BasePoleCalculator bpc = new BasePoleCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = bpc.calcPoles(list, 300, 300, 200);
        // Assert:
        assertEquals(6, list.size());
    }

    @Test
    public void CalcRaftsWithMediumCarport() throws FogException {
        // Arrange:
        BaseRaftCalculator brc = new BaseRaftCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = brc.calcRafts(list, 300, 300);
        // Assert:
        assertEquals(12, list.size());
    }

    // Test with input over breakpoint 
    @Test
    public void CalcPolesWithBigCarport() throws FogException {
        // Arrange:
        BasePoleCalculator bpc = new BasePoleCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = bpc.calcPoles(list, 600, 600, 200);
        // Assert:
        assertEquals(9, list.size());
    }

    @Test
    public void CalcRaftsWithBigCarport() throws FogException {
        // Arrange:
        BaseRaftCalculator brc = new BaseRaftCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = brc.calcRafts(list, 600, 600);
        // Assert:
        assertEquals(16, list.size());
    }
}
