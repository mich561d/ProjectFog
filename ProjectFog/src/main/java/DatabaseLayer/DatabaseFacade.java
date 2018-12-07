package DatabaseLayer;

import DatabaseLayer.Mappers.*;
import FunctionLayer.Entities.Address;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Entities.Employee;
import FunctionLayer.Entities.Part;
import FunctionLayer.Entities.PaymentInformation;
import FunctionLayer.Entities.User;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import java.util.ArrayList;

/**
 *
 * @author Michael & Christian
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

    public static int createAddress(String city, String zip, String street, String number, int id, boolean customer) throws RegisterException {
        return AddressMapper.createAddress(city, zip, street, number, id, customer);
    }

    public static int createPaymentInformation(String cardNumber, String expireDate, int customerID) throws RegisterException {
        return PaymentInformationMapper.createPaymentInformation(cardNumber, expireDate, customerID);
    }

    public static int createUser(String email, String hashedPassword, String salt, int id, boolean customer) throws RegisterException {
        return UserMapper.createUser(email, hashedPassword, salt, id, customer);
    }

    public static int createCustomer(String firstName, String lastName, String phone) throws RegisterException, FogException {
        return CustomerMapper.createCustomer(firstName, lastName, phone);
    }

    public static Customer getCustomerByID(int id) throws FogException {
        return CustomerMapper.getCustomerByID(id);
    }

    public static Address getAddressByID(int id) throws FogException {
        return AddressMapper.getAddressByCustomerID(id);
    }

    public static PaymentInformation getPaymentInformationByID(int id) throws FogException {
        return PaymentInformationMapper.getPaymentInformationByID(id);
    }

    public static User getUserByID(int id) throws FogException {
        return UserMapper.getUserByCustomerID(id);
    }

    public static ArrayList<Part> getAllRoofBricksAsList() throws FogException {
        return PartMapper.getAllRoofBricksAsList();
    }

    public static Employee getEmployeeByID(int id) throws FogException {
        return EmployeeMapper.getEmployeeByID(id);
    }

    public static void updateCardNumber(int id, String cardNumber) throws RegisterException {
        PaymentInformationMapper.updateCardNumber(id, cardNumber);
    }

    public static void updateExpireDate(int id, String expireDate) throws RegisterException {
        PaymentInformationMapper.updateExpireDate(id, expireDate);
    }

    public static void updateCity(int customerID, String city) throws RegisterException {
        AddressMapper.updateCity(customerID, city);
    }

    public static void updateZip(int customerID, String zip) throws RegisterException {
        AddressMapper.updateZip(customerID, zip);
    }

    public static void updateStreet(int customerID, String street) throws RegisterException {
        AddressMapper.updateStreet(customerID, street);
    }

    public static void updateNumber(int customerID, String number) throws RegisterException {
        AddressMapper.updateNumber(customerID, number);
    }

    public static void updateFirstName(int id, String firstName) throws RegisterException {
        CustomerMapper.updateFirstName(id, firstName);
    }

    public static void updateLastName(int id, String lastName) throws RegisterException {
        CustomerMapper.updateLastName(id, lastName);
    }

    public static void updatePhone(int id, String phone) throws RegisterException {
        CustomerMapper.updatePhone(id, phone);
    }
}
