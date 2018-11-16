package DatabaseLayer;

import DatabaseLayer.Mappers.PartMapper;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;

/**
 *
 * @author Michael
 */
public class DatabaseFacade {
    
    public static Part getPart(String type, String material, String size) throws FogException {
        return PartMapper.getPartByTypeMaterialSize(type, material, size);
    }
}
