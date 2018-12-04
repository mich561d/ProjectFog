package DatabaseLayer;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class DBConnectorTest {

    @Test
    public void TestConnection1() throws ClassNotFoundException, SQLException {
        // Arrange & Act:
        Connection connection = DatabaseConnector.connection();
        // Assert:
        assertNotNull(connection);
    }

    @Test
    public void TestConnection2() throws ClassNotFoundException, SQLException {
        // Arrange & Act:
        DatabaseConnector.setConnection(null);
        // Assert:
        assertNotNull(DatabaseConnector.connection());
    }
}
