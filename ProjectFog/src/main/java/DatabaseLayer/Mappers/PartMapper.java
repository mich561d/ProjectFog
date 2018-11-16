package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.Part;
import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class PartMapper {

    public static Part getPartByTypeMaterialSize(String t, String m, String s) throws FogException {
        Part part = null;
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM part WHERE type = ? AND material = ? AND size = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, t); // t = type
            ps.setString(2, m); // m = material
            ps.setString(3, s); // s = size
            ResultSet ids = ps.executeQuery();
            if (ids.next()) {
                int id = ids.getInt("id");
                String type = ids.getString("type");
                String material = ids.getString("material");
                String size = ids.getString("size");
                String description = ids.getString("description");
                String brand = ids.getString("brand");
                double price = ids.getDouble("price");
                part = new Part(id, type, material, size, description, brand, price);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage());
        }
        return part;
    }

}
