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

    public static int createAddress(String city, String zip, String street, String number, int id, boolean customer) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO address(city, zip, street, number, customerID, employeeID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, city);
            ps.setString(2, zip);
            ps.setString(3, street);
            ps.setString(4, number);
            if (customer) {
                ps.setInt(5, id);
                ps.setInt(6, 0);
            } else {
                ps.setInt(5, 0);
                ps.setInt(6, id);
            }
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
            String SQL = "SELECT * FROM address WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String zip = rs.getString("zip");
                String street = rs.getString("street");
                String number = rs.getString("number");
                Address payment = new Address(id, city, zip, street, number, customerID, 0);
                return payment;
            } else {
                throw new FogException("Adressen med kunde id'et " + customerID + ", findes ikke!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static Address getAddressByEmployeeID(int employeeID) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM address WHERE employeeID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String zip = rs.getString("zip");
                String street = rs.getString("street");
                String number = rs.getString("number");
                Address payment = new Address(id, city, zip, street, number, 0, employeeID);
                return payment;
            } else {
                throw new FogException("Adressen med arbejder id'et " + employeeID + ", findes ikke!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }
}
