package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.PaymentInformation;
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
public class PaymentInformationMapper {

    public static int getPaymentInformation(String cardNumber) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM paymentInformation WHERE cardNumber = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cardNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
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
                return rs.getInt(1);
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RegisterException(ex.getMessage(), Level.SEVERE);
            }
        }
    }

    public static PaymentInformation getPaymentInformationByID(int id) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM paymentInformation WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cardNumber = rs.getString("cardNumber");
                String expireDate = rs.getString("expireDate");
                PaymentInformation payment = new PaymentInformation(id, cardNumber, expireDate);
                return payment;
            } else {
                throw new FogException("kortet med id'et " + id + ", findes ikke!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }
}
