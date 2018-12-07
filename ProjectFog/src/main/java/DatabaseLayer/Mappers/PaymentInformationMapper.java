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
 * @author Michael & Christian
 */
public class PaymentInformationMapper {

    public static int createPaymentInformation(String cardNumber, String expireDate, int customerID) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO paymentInformation(cardNumber, expireDate, customerID) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cardNumber);
            ps.setString(2, expireDate);
            ps.setInt(3, customerID);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static PaymentInformation getPaymentInformationByID(int customerID) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM paymentInformation WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String cardNumber = rs.getString("cardNumber");
                String expireDate = rs.getString("expireDate");
                PaymentInformation payment = new PaymentInformation(id, cardNumber, expireDate, customerID);
                return payment;
            } else {
                throw new FogException("kortet med kunde id'et " + customerID + ", findes ikke!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static int updatePaymentInformationByID(int customerID, String cardNumber, String expireDate) throws FogException, RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE `paymentInformation` SET `cardNumber` = ?, `cardExpireDate` = ? WHERE `customerID` = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cardNumber);
            ps.setString(2, expireDate);
            ps.setInt(3, customerID);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }
}
