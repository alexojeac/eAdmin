package db;

/**
 *
 * @author Alejandro Ojea
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    public static void connect(String dbHost, String dbUsername, String dbPassword) {
        Properties props = new Properties();
        props.setProperty("user", dbUsername);
        props.setProperty("password", dbPassword);

        try {
            String url = "jdbc:mysql://" + dbHost;
            connection = DriverManager.getConnection(url, props);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
