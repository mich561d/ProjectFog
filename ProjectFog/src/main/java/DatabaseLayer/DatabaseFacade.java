package DatabaseLayer;

import DatabaseLayer.Mappers.PartMapper;
import DatabaseLayer.Mappers.UserMapper;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;

/**
 *
 * @author Michael
 */
public class DatabaseFacade {
    
    public static Part getPart(String type, String material, String size) throws FogException {
        return PartMapper.getPartByTypeMaterialSize(type, material, size);
    }
    
    public static int login(String email, String password) throws LoginException {
        return UserMapper.getLoginId(email, password);
    }
    
    public static String getSaltValue(String email) throws LoginException {
        return UserMapper.getSaltValue(email);
    }
}
