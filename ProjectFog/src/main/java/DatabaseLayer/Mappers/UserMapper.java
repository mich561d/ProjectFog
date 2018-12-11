package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.User;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
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
public class UserMapper {

    public static String getSaltValue(String email) throws LoginException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT `saltValue` FROM `user` WHERE BINARY `email` = ?";
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
            String SQL = "SELECT * FROM `user` WHERE BINARY `email` = ? AND BINARY `password` = ?";
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

    public static boolean doEmailExist(String email) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `user` WHERE BINARY `email` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new RegisterException("Email already exists!");
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static int createUser(String email, String hashedPassword, String salt) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO `user`(email, password, saltValue) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.setString(2, hashedPassword);
            ps.setString(3, salt);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static User getUserByID(int id) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `user` WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String email = rs.getString("email");
                String hashedPassword = rs.getString("password");
                String saltValue = rs.getString("saltValue");
                User user = new User(id, email, hashedPassword, saltValue);
                return user;
            } else {
                throw new FogException("webbrugeren med id'et " + id + ", findes ikke!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updateEmail(int customerID, String email) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE `user` SET `email` = ? WHERE `customerID` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void updatePassword(int customerID, String password) throws RegisterException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "UPDATE `user` SET `password` = ? WHERE `customerID` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, password);
            ps.setInt(2, customerID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RegisterException(ex.getMessage(), Level.SEVERE);
        }
    }

}
