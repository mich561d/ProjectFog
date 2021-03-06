package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.RegisterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author Michael & Christian
 */
public class CustomerMapper {

    public static int createCustomer(String firstName, String lastName, String phone, int userID) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO `customer`(firstName, lastName, phone, userID) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phone);
            ps.setInt(4, userID);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static Customer getCustomerByUserID(int userID) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `customer` WHERE `userID` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phone = rs.getString("phone");
                Customer customer = new Customer(id, firstName, lastName, phone, userID);
                return customer;
            } else {
                throw new FogException("Brugeren findes ikke i systemet!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static Customer getCustomerByID(int id) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `customer` WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phone = rs.getString("phone");
                int userID = rs.getInt("userID");
                Customer customer = new Customer(id, firstName, lastName, phone, userID);
                return customer;
            } else {
                throw new FogException("Brugeren findes ikke i systemet!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateFirstName(int id, String firstName) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE `customer` SET `firstName` = ? WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, firstName);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateLastName(int id, String lastName) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE `customer` SET `lastName` = ? WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, lastName);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updatePhone(int id, String phone) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE `customer` SET `phone` = ? WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, phone);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }
}
