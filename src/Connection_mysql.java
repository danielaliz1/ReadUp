package ReadUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connection_mysql {

    private static final String  URL = "mysql://[root]:[M0na14!#o6]@[localhost]:[3306]/[ReadUp]";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);

}


}
