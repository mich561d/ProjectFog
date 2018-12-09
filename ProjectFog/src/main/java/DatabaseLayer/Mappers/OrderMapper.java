package DatabaseLayer.Mappers;

import DatabaseLayer.DatabaseConnector;
import FunctionLayer.Entities.Order;
import FunctionLayer.Enums.OrderStatus;
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
public class OrderMapper {

    public static ArrayList<Order> getAllOrdersByCustomerID(int customerID) throws FogException {
        try {
            Connection con = DatabaseConnector.connection();
            String SQL = "SELECT * FROM order WHERE customerID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("orderStatus");
                String boughtDate = rs.getString("boughtDate");
                String sentDate = rs.getString("delieveredDate");
                int productID = rs.getInt("productID");
                Order order = new Order(id, OrderStatus.valueOf(status), boughtDate, sentDate, productID, customerID);
                orders.add(order);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), Level.SEVERE);
        }
    }

}
