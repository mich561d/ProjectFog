package DatabaseLayer;

import DatabaseLayer.Mappers.PartMapper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class PartTest {

    @Test
    public void GetPartFromDatabase() throws FogException {
        // Arrange & Act: 
        Part part = PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 300cm");
        // Assert:
        assertNotNull(part);
    }

    @Test//(expected = FogException.class)
    public void GetPartFromDatabaseWrongData() throws FogException {
        // Arrange & Act --> Assert: 
        //Part part = PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 290cm");

        // Arrange & Act:
        Part part = PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 290cm");
        // Assert:
        assertNull(part);
    }

    @Test
    public void GetPartFromDatabaseEmptyData() throws FogException {
        // Arrange & Act:
        Part part = PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 290cm");
        // Assert:
        assertNull(part);
    }

    @Test
    public void GetPartFromDatabaseNullData() throws FogException {
        // Arrange & Act:
        Part part = PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 290cm");
        // Assert:
        assertNull(part);
    }
}
