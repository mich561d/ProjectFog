package DatabaseLayer;

import DatabaseLayer.Mappers.*;
import FunctionLayer.Entities.Address;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Entities.Part;
import FunctionLayer.Entities.PaymentInformation;
import FunctionLayer.Entities.User;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import java.util.ArrayList;

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

    public static Customer getCustomerByUserID(int id) throws FogException {
        return CustomerMapper.getCustomerByUserID(id);
    }

    public static Customer getCustomerByID(int id) throws FogException {
        return CustomerMapper.getCustomerByID(id);
    }

    public static Address getAddressByID(int id) throws FogException {
        return AddressMapper.getAddressByID(id);
    }

    public static PaymentInformation getPaymentInformationByID(int id) throws FogException {
        return PaymentInformationMapper.getPaymentInformationByID(id);
    }

    public static User getUserByID(int id) throws FogException {
        return UserMapper.getUserByID(id);
    }
    
    public static ArrayList<Part> getAllRoofBricksAsList() throws FogException {
        return PartMapper.getAllRoofBricksAsList();
    }
}
