package DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Michael & Christian
 */
public class DatabaseConnector {

    private static final String IP = "104.248.29.81";
    private static final String PORT = "3306";
    public static final String DATABASE = "ProjectFogDatabase";
    private static final String USERNAME = "Michael";
    private static final String PASSWORD = "1997DuE";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }
}
