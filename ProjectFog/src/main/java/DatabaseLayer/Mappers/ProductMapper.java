package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.Carport;
import FunctionLayer.Exceptions.FogException;
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
public class ProductMapper {

    public static Carport getProductFromOrderByID(int id) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM carport WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int carportLength = rs.getInt("length");
                int carportWidth = rs.getInt("width");
                int carportHeight = rs.getInt("height");
                boolean angledRoof = 1 == rs.getByte("roof");
                int angle = rs.getInt("angle");
                String roofing = rs.getString("roofing");
                boolean hasShed = 1 == rs.getByte("shed");
                int shedLength = rs.getInt("shedLength");
                int shedWidth = rs.getInt("shedWidth");
                String flooring = rs.getString("flooring");
                Carport product = new Carport(id, carportLength, carportWidth, carportHeight, angledRoof, angle, roofing, hasShed, shedLength, shedWidth, flooring);
                return product;
            } else {
                throw new FogException("Kunne ikke finde det ønskede product!", Level.SEVERE);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    public static int createProduct(Carport carport) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "INSERT INTO carport(length, width, height, roof, angle, roofing, shed, shedLength, shedWidth, flooring) VALUES"
                    + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carport.getCarportLength());
            ps.setInt(2, carport.getCarportWidth());
            ps.setInt(3, carport.getCarportHeight());
            ps.setByte(4, booleanToByte(carport.isAngledRoof()));
            ps.setInt(5, carport.getAngle());
            ps.setString(6, carport.getRoofing());
            ps.setByte(7, booleanToByte(carport.isShed()));
            ps.setInt(8, carport.getShedLength());
            ps.setInt(9, carport.getShedWidth());
            ps.setString(10, carport.getFlooring());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

    private static byte booleanToByte(boolean b) {
        if (b) {
            return 1;
        } else {
            return 0;
        }
    }

}
