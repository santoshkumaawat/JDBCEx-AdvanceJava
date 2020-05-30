package JDBC.Employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    public static Connection connect() throws Exception {
        Class.forName(Data.DRIVER_NAME);
        Connection con = DriverManager.getConnection(Data.URL, Data.USERNAME, Data.PASSWORD);
        return con;
    }
}
