package FunctionLayer;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Calculation.Roof.RoofAngledCalculator;
import FunctionLayer.Calculation.Roof.RoofFlatCalculator;
import FunctionLayer.Entities.Part;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
// WRNS = With Roof, No Shed
public class RoofCarportCalculatorTest {

    // Test with input under breakpoint
    @Test
    public void CalcSmallFlatRoof() throws FogException {
        // Arrange:
        RoofFlatCalculator rfc = new RoofFlatCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = rfc.calcFlatRoof(list, 240, 240);
        // Assert:
        assertEquals(15, list.size());
    }

    @Test
    public void CalcSmallAngledRoof() throws FogException {
        // Arrange:
        RoofAngledCalculator rac = new RoofAngledCalculator();
        // Act: 
        ArrayList<Part> list = testList("small");
        list = rac.calcAngledRoof(list, 240, 240, 20);
        // Assert:
        assertEquals(54, list.size());
    }

    // Test with input at breakpoint
    @Test
    public void CalcMediumFlatRoof() throws FogException {
        // Arrange:
        RoofFlatCalculator rfc = new RoofFlatCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = rfc.calcFlatRoof(list, 300, 300);
        // Assert:
        assertEquals(17, list.size());
    }

    @Test
    public void CalcMediumAngledRoof() throws FogException {
        // Arrange:
        RoofAngledCalculator rac = new RoofAngledCalculator();
        // Act: 
        ArrayList<Part> list = testList("medium");
        list = rac.calcAngledRoof(list, 300, 300, 20);
        // Assert:
        assertEquals(73, list.size());
    }

    // Test with input over breakpoint 
    @Test
    public void CalcBigFlatRoof() throws FogException {
        // Arrange:
        RoofFlatCalculator rfc = new RoofFlatCalculator();
        // Act: 
        ArrayList<Part> list = new ArrayList();
        list = rfc.calcFlatRoof(list, 600, 600);
        // Assert:
        assertEquals(27, list.size());
    }

    @Test
    public void CalcBigAngledRoof() throws FogException {
        // Arrange:
        RoofAngledCalculator rac = new RoofAngledCalculator();
        // Act: 
        ArrayList<Part> list = testList("big");
        list = rac.calcAngledRoof(list, 600, 600, 20);
        // Assert:
        assertEquals(190, list.size());
    }

    private ArrayList<Part> testList(String level) throws FogException {
        ArrayList<Part> list = new ArrayList();
        int times;
        switch (level) {
            case "small":
                times = 10;
                break;
            case "medium":
                times = 15;
                break;
            case "big":
                times = 20;
                break;
            default:
                times = 10;
                break;
        }
        for (int i = 0; i < times; i++) {
            String type = "Spær", material = "Ubh. Fyr", size = "47x200mm 300cm";
            Part part = DatabaseFacade.getPart(type, material, size);
            list.add(part);
        }
        return list;
    }

}
