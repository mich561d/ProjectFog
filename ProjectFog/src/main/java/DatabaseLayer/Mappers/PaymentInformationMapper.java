package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
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
public class PaymentInformationMapper {

    public static int getPaymentInformation(String cardNumber) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM paymentInformation WHERE cardNumber = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cardNumber);
            ResultSet ids = ps.executeQuery();
            if (ids.next()) {
                return ids.getInt("id");
            } else {
                throw new RegisterException("PaymentInformation is not stored!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static int createPaymentInformation(String cardNumber, String expireDate) throws RegisterException {
        try {
            return getPaymentInformation(cardNumber);
        } catch (RegisterException e) {
            try {
                Connection con = DatabaseConnector.connection();
                String SQL = "INSERT INTO paymentInformation(cardNumber, expireDate) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, cardNumber);
                ps.setString(2, expireDate);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt("id");
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RegisterException(ex.getMessage(), Level.SEVERE);
            }
        }
    }
}
