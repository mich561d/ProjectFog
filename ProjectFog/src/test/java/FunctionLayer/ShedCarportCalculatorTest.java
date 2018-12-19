package FunctionLayer;

import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Calculation.Shed.ShedCladdingCalculator;
import FunctionLayer.Calculation.Shed.ShedDoorCalculator;
import FunctionLayer.Calculation.Shed.ShedFloorCalculator;
import FunctionLayer.Calculation.Shed.ShedPolesCalculator;
import FunctionLayer.Entities.Part;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael & Christian
 */
public class ShedCarportCalculatorTest {

    @Test
    public void CalcDoor() throws FogException {
        // Arrange:
        ShedDoorCalculator sdc = new ShedDoorCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = sdc.calcDoor(list);
        // Assert:
        assertEquals(14, list.size());
    }

    @Test
    public void CalcShedPolesWithLowerLengthAndWidthThanCarport() throws FogException {
        // Arrange:
        ShedPolesCalculator spc = new ShedPolesCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = spc.calcPoles(240, 240, 200, 100, 100, list);
        // Assert:
        assertEquals(4, list.size());
    }

    @Test
    public void CalcShedPolesWithLowerLengthAndEqualWidthThanCarport() throws FogException {
        // Arrange:
        ShedPolesCalculator spc = new ShedPolesCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = spc.calcPoles(240, 240, 200, 100, 210, list);
        // Assert:
        assertEquals(3, list.size());
    }

    @Test
    public void CalcShedPolesWithEqualLengthAndLowerWidthThanCarport() throws FogException {
        // Arrange:
        ShedPolesCalculator spc = new ShedPolesCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = spc.calcPoles(240, 240, 200, 210, 100, list);
        // Assert:
        assertEquals(3, list.size());
    }

    @Test
    public void CalcShedPolesWithEqualLengthAndWidthThanCarport() throws FogException {
        // Arrange:
        ShedPolesCalculator spc = new ShedPolesCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = spc.calcPoles(240, 240, 200, 210, 210, list);
        // Assert:
        assertEquals(1, list.size());
    }

    @Test
    public void CalcShedCladding() throws FogException {
        // Arrange:
        ShedCladdingCalculator scc = new ShedCladdingCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = scc.calcCladdingAndInterTies(100, 100, list);
        // Assert:
        assertEquals(58, list.size());
    }
    
    @Test
    public void CalcShedFloor() throws FogException {
            // Arrange:
            ShedFloorCalculator sfc = new ShedFloorCalculator();
            // Act:
            ArrayList<Part> list = new ArrayList();
            list = sfc.calcFloor(200, 200, list);
            // Assert:
            assertEquals(16, list.size());
    }
}
