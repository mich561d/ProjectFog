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

    @Test(expected = FogException.class)
    public void GetPartFromDatabaseThatDoNotExist() {
        // Arrange & Act: 
        //Part part = PartMapper.getPartByTypeMaterialSize("Stolpe", "Trykimp Fyr", "97x97mm 290cm");

        
        /*
        try {
        method
        fail
        }catch{
        assert
        }
        */
    }
}
