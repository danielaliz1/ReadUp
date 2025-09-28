import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connection_mysql {
    private static final String URL = "jdbc:mysql://localhost:3306/readup";
    private static final String USER = "root";
    private static final String PASSWORD = "M0na14!#o6";

    public static Connection getConnection() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectada.");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }
}




