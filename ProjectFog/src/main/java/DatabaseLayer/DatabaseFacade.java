package DatabaseLayer;

import DatabaseLayer.Mappers.*;
import FunctionLayer.Entities.Address;
import FunctionLayer.Entities.Carport;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Entities.Employee;
import FunctionLayer.Entities.Order;
import FunctionLayer.Entities.Part;
import FunctionLayer.Entities.User;
import FunctionLayer.Enums.EmployeeRole;
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

    public static int createAddress(String city, String zip, String street, String number, int customerID) throws RegisterException {
        return AddressMapper.createAddress(city, zip, street, number, customerID);
    }

    public static int createUser(String email, String hashedPassword, String salt) throws RegisterException {
        return UserMapper.createUser(email, hashedPassword, salt);
    }

    public static int createCustomer(String firstName, String lastName, String phone, int userID) throws RegisterException, FogException {
        return CustomerMapper.createCustomer(firstName, lastName, phone, userID);
    }

    public static Customer getCustomerByUserID(int userID) throws FogException {
        return CustomerMapper.getCustomerByUserID(userID);
    }

    public static Customer getCustomerByID(int id) throws FogException {
        return CustomerMapper.getCustomerByID(id);
    }

    public static Address getAddressByID(int id) throws FogException {
        return AddressMapper.getAddressByCustomerID(id);
    }

    public static User getUserByID(int id) throws FogException {
        return UserMapper.getUserByID(id);
    }

    public static ArrayList<Part> getAllRoofBricksAsList() throws FogException {
        return PartMapper.getAllRoofBricksAsList();
    }

    public static Employee getEmployeeByUserID(int userID) throws FogException {
        return EmployeeMapper.getEmployeeByUserID(userID);
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

    public static void updateEmail(int id, String email) throws RegisterException {
        UserMapper.updateEmail(id, email);
    }

    public static void updatePassword(int id, String password) throws RegisterException {
        UserMapper.updatePassword(id, password);
    }

    public static ArrayList<Order> getAllOrdersByCustomerID(int id) throws FogException {
        return OrderMapper.getAllOrdersByCustomerID(id);
    }

    public static Carport getProductFromOrderByID(int id) throws FogException {
        return ProductMapper.getProductFromOrderByID(id);
    }

    public static int createProduct(Carport carport) throws FogException {
        return ProductMapper.createProduct(carport);
    }

    public static void createOrder(int customerID, int productID) throws FogException {
        OrderMapper.createOrder(customerID, productID);
    }

    public static void deleteUser(int id) throws FogException {
        UserMapper.deleteUser(id);
    }

    public static int createEmployee(String firstName, String lastName, String phone, String workPhone, EmployeeRole role, int userID) throws RegisterException {
        return EmployeeMapper.createEmployee(firstName, lastName, phone, workPhone, role, userID);
    }
    
    public static ArrayList<Order> getAllOrders() throws FogException {
        return OrderMapper.getAllOrders();
    }

    public static void sentOrder(int orderID) throws FogException {
        OrderMapper.sentOrder(orderID);
    }
}
