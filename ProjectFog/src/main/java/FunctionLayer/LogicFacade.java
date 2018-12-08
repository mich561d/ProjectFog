package FunctionLayer;

import DatabaseLayer.DatabaseFacade;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Calculation.CarportCalculator;
import FunctionLayer.Entities.Address;
import FunctionLayer.Entities.Carport;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Entities.Employee;
import FunctionLayer.Entities.Order;
import FunctionLayer.Util.UtilCarportDrawing;
import FunctionLayer.Entities.Part;
import FunctionLayer.Entities.PaymentInformation;
import FunctionLayer.Entities.User;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael & Christian
 */
public class LogicFacade {

    private static CarportCalculator cc = new CarportCalculator(0, 0, 0, 0, false, false, 0, 0, "Tagpap");

    public static void calculateCustomCarport(int length, int width, int height, int angle, boolean angledRoof, boolean shed, int shedLength, int shedWidth, String roofing) throws FogException {
        cc = new CarportCalculator(length, width, height, angle, angledRoof, shed, shedLength, shedWidth, roofing);
        cc.calcCarport();
    }

    public static double getPriceFromCarport() throws FogException {
        return cc.getTotalPrice();
    }

    public static ArrayList<Part> getProductListFromCarport() throws FogException {
        return cc.getProductList();
    }

    public static HashMap<String, ArrayList<Part>> getProductMapFromCarport() {
        return cc.getProductMap();
    }

    public static String getDrawingFromAbove(int length, int width, boolean angledRoof) {
        return UtilCarportDrawing.drawSchematicViewFromAbove(length, width, angledRoof);
    }

    public static String getDrawingFromAside(int length, int height) {
        return UtilCarportDrawing.drawSchematicViewFromAside(length, height);
    }

    public static String getDrawingFromFront(int width, int height) {
        return UtilCarportDrawing.drawSchematicViewFromFront(width, height);
    }

    public static String getRandomSaltString(int length) {
        return Hashing.getRandomSaltString(length);
    }
    
    public static String getSaltString(String email) throws LoginException {
        return DatabaseFacade.getSaltValue(email);
    } 

    public static String hashPassword(String password, String salt) throws FogException {
        String concat = password.concat(salt);
        return Hashing.hashPassword(concat);
    }

    public static int login(String email, String password) throws LoginException, FogException {
        String salt = DatabaseFacade.getSaltValue(email);
        String hashedPassword = hashPassword(password, salt);
        return DatabaseFacade.login(email, hashedPassword);
    }

    public static boolean doEmailExist(String email) throws RegisterException {
        return DatabaseFacade.doEmailExist(email);
    }

    public static boolean checkPasswords(String pass1, String pass2) throws RegisterException {
        return PasswordComparator.checkPasswords(pass1, pass2);
    }

    public static int createAddress(String city, String zip, String street, String number, int id, boolean customer) throws RegisterException {
        return DatabaseFacade.createAddress(city, zip, street, number, id, customer);
    }

    public static int createPaymentInformation(String cardNumber, String ExpireDate, int customerID) throws RegisterException {
        return DatabaseFacade.createPaymentInformation(cardNumber, ExpireDate, customerID);
    }

    public static int createUser(String email, String password, int id, boolean customer) throws RegisterException, FogException {
        String salt = Hashing.getRandomSaltString(0);
        String hashedPassword = Hashing.hashPassword(password.concat(salt));
        return DatabaseFacade.createUser(email, hashedPassword, salt, id, customer);
    }

    public static int createCustomer(String firstName, String lastName, String phone) throws RegisterException, FogException {
        return DatabaseFacade.createCustomer(firstName, lastName, phone);
    }

    public static Customer getCustomerByID(int id) throws FogException {
        return DatabaseFacade.getCustomerByID(id);
    }

    public static Address getAddressByID(int id) throws FogException {
        return DatabaseFacade.getAddressByID(id);
    }

    public static PaymentInformation getPaymentInformationByID(int id) throws FogException {
        return DatabaseFacade.getPaymentInformationByID(id);
    }

    public static User getUserByID(int id) throws FogException {
        return DatabaseFacade.getUserByID(id);
    }

    public static ArrayList<Part> getAllRoofBricksAsList() throws FogException {
        return DatabaseFacade.getAllRoofBricksAsList();
    }

    public static Employee getEmployeeByID(int id) throws FogException {
        return DatabaseFacade.getEmployeeByID(id);
    }

    public static void updateCardNumber(int id, String cardNumber) throws RegisterException {
        DatabaseFacade.updateCardNumber(id, cardNumber);
    }

    public static void updateExpireDate(int id, String expireDate) throws RegisterException {
        DatabaseFacade.updateExpireDate(id, expireDate);
    }

    public static void updateCity(int customerID, String city) throws RegisterException {
        DatabaseFacade.updateCity(customerID, city);
    }

    public static void updateZip(int customerID, String zip) throws RegisterException {
        DatabaseFacade.updateZip(customerID, zip);
    }

    public static void updateStreet(int customerID, String street) throws RegisterException {
        DatabaseFacade.updateStreet(customerID, street);
    }

    public static void updateNumber(int customerID, String number) throws RegisterException {
        DatabaseFacade.updateNumber(customerID, number);
    }

    public static void updateFirstName(int id, String firstName) throws RegisterException {
        DatabaseFacade.updateFirstName(id, firstName);
    }

    public static void updateLastName(int id, String lastName) throws RegisterException {
        DatabaseFacade.updateLastName(id, lastName);
    }

    public static void updatePhone(int id, String phone) throws RegisterException {
        DatabaseFacade.updatePhone(id, phone);
    }

    public static void updateEmail(int customerID, String email) throws RegisterException {
        DatabaseFacade.updateEmail(customerID, email);
    }

    public static void updatePassword(int customerID, String password) throws RegisterException {
        DatabaseFacade.updatePassword(customerID, password);
    }

    public static ArrayList<Order> getAllOrdersByCustomerID(int id) {
        return DatabaseFacade.getAllOrdersByCustomerID(id);
    }

    public static Carport getProductFromOrderByID(int id) {
        return DatabaseFacade.getProductFromOrderByID(id);
    }
}
