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
 * @author Michael
 */
public class CustomerMapper {

    public static int createCustomer(String firstName, String lastName, String phone, int paymentID, int addressID, int userID) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO customer(firstName, lastName, phone, paymentID, addressID, userID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phone);
            ps.setInt(4, paymentID);
            ps.setInt(5, addressID);
            ps.setInt(6, userID);
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
            String SQL = "SELECT * FROM customer WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet ids = ps.executeQuery();
            if (ids.next()) {
                int id = ids.getInt("id");
                String firstName = ids.getString("firstName");
                String lastName = ids.getString("lastName");
                String phone = ids.getString("phone");
                int paymentID = ids.getInt("paymentID");
                int addressID = ids.getInt("addressID");
                Customer c = new Customer(firstName, lastName, phone, paymentID, addressID, userID);
                c.setId(id);
                return c;
            } else {
                throw new FogException("Customer is not in the system", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }
}
