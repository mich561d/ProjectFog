package DatabaseLayer;

import DatabaseLayer.Mappers.PartMapper;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael & Christian
 */
public class PartTest {

    @Test
    public void GetPartFromDatabase() {
        // Arrange & Act: 
        try {
            PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 300cm");
        } catch (FogException ex) {
            // Assert:
            fail("Should not have thrown error!");
        }
    }

    @Test
    public void GetPartFromDatabaseWrongData() {
        // Arrange & Act:
        try {
            PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 290cm");
            // Assert:
            fail("Should not have thrown error!");
        } catch (FogException ex) {
        }
    }

    @Test
    public void GetPartFromDatabaseEmptyData() {
        // Arrange & Act:
        try {
            PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "");
            // Assert:
            fail("Should not have thrown error!");
        } catch (FogException ex) {
        }
    }

    @Test
    public void GetPartFromDatabaseNullData() {
        // Arrange & Act:
        try {
            PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", null);
            // Assert:
            fail("Should not have thrown error!");
        } catch (FogException ex) {
        }
    }

    @Test
    public void GetListOfRoofing() throws FogException {
        // Arrange:
        ArrayList<Part> list;
        // Act: 
        list = PartMapper.getAllRoofBricksAsList();
        // Assert:
        assertEquals(2, list.size());
    }
}
