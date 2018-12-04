package DatabaseLayer;

import DatabaseLayer.Mappers.*;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;

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

    public static boolean doEmailExist(String email) throws RegisterException {
        return UserMapper.doEmailExist(email);
    }

    public static int createAddress(String city, String zip, String street, String number) throws RegisterException {
        return AddressMapper.createAddress(city, zip, street, number);
    }

    public static int createPaymentInformation(String cardNumber, String expireDate) throws RegisterException {
        return PaymentInformationMapper.createPaymentInformation(cardNumber, expireDate);
    }

    public static int createUser(String email, String hashedPassword, String salt) throws RegisterException {
        return UserMapper.createUser(email, hashedPassword, salt);
    }

    public static int createCustomer(String firstName, String lastName, String phone, int paymentID, int addressID, int userID) throws RegisterException, FogException {
        return CustomerMapper.createCustomer(firstName, lastName, phone, paymentID, addressID, userID);
    }
}
