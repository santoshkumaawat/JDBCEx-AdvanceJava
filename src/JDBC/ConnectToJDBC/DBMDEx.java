package JDBC.ConnectToJDBC;

import JDBC.Employee.ConnectionProvider;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DBMDEx {

    public static void main(String[] args) throws Exception {
        try (Connection con = ConnectionProvider.connect()) {
            DatabaseMetaData dbmd = con.getMetaData();
            
            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseProductVersion());
            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getDriverVersion());
            System.out.println(dbmd.getJDBCMajorVersion());
        }
    }
}
