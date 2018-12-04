package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Exceptions.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Michael
 */
public class UserMapper {

    public static String getSaltValue(String email) throws LoginException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT saltValue FROM user "
                    + "WHERE BINARY email=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("saltValue");
            } else {
                throw new LoginException("User '" + email + "' do not exist!", Level.INFO);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static int getLoginId(String email, String password) throws LoginException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM user "
                    + "WHERE BINARY email=? AND BINARY password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new LoginException("Could not validate user", Level.INFO);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginException(ex.getMessage(), Level.SEVERE);
        }
    }

}
