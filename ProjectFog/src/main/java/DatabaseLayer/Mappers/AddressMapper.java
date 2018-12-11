package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.Address;
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
public class AddressMapper {

    public static int createAddress(String city, String zip, String street, String number, int customerID) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO address(city, zip, street, number, customerID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, city);
            ps.setString(2, zip);
            ps.setString(3, street);
            ps.setString(4, number);
            ps.setInt(5, customerID);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static Address getAddressByCustomerID(int customerID) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `address` WHERE `customerID` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String zip = rs.getString("zip");
                String street = rs.getString("street");
                String number = rs.getString("number");
                Address payment = new Address(id, city, zip, street, number, customerID);
                return payment;
            } else {
                throw new FogException("Adressen med kunde id'et " + customerID + ", findes ikke!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateCity(int customerID, String city) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE address SET city = ? WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, city);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateZip(int customerID, String zip) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE address SET zip = ? WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, zip);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateStreet(int customerID, String street) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE address SET street = ? WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, street);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateNumber(int customerID, String number) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE address SET number = ? WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, number);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }
}
