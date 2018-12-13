package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Michael & Christian
 */
public class PartMapper {

    public static Part getPartByTypeMaterialSize(String t, String m, String s) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `part` WHERE `type` = ? AND `material` = ? AND `size` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, t); // t = type
            ps.setString(2, m); // m = material
            ps.setString(3, s); // s = size
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String material = rs.getString("material");
                String size = rs.getString("size");
                String description = rs.getString("description");
                String brand = rs.getString("brand");
                double price = rs.getDouble("price");
                return new Part(id, type, material, size, description, brand, price);
            } else {
                throw new FogException("Der er fejl i databasen, da vi ikke kan finde delen!", Level.WARNING);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static ArrayList<Part> getAllRoofBricksAsList() throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `part` WHERE `material` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "Tegl"); // m = material
            ResultSet rs = ps.executeQuery();
            ArrayList<Part> roofBricks = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String material = rs.getString("material");
                String size = rs.getString("size");
                String description = rs.getString("description");
                String brand = rs.getString("brand");
                double price = rs.getDouble("price");
                Part part = new Part(id, type, material, size, description, brand, price);
                roofBricks.add(part);
            }
            if (roofBricks.isEmpty()) {
                throw new FogException("Der er fejl i databasen, da vi ikke kan finde tagstenene!", Level.WARNING);
            }
            return roofBricks;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static ArrayList<Part> getAllParts() throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM `part`";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ArrayList<Part> parts = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String material = rs.getString("material");
                String size = rs.getString("size");
                String description = rs.getString("description");
                String brand = rs.getString("brand");
                double price = rs.getDouble("price");
                Part part = new Part(id, type, material, size, description, brand, price);
                parts.add(part);
            }
            if (parts.isEmpty()) {
                throw new FogException("Der er fejl i databasen, da vi ikke kan finde nogen materialer!", Level.WARNING);
            }
            return parts;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void createPart(String type, String material, String size, String description, double price, String brand) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO `part`(type, material, size, description, price, brand) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, type);
            ps.setString(2, material);
            ps.setString(3, size);
            ps.setString(4, description);
            ps.setDouble(5, price);
            ps.setString(6, brand);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static void deletePart(int partID) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "DELETE FROM `part` WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, partID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

}
