package JDBC.ConnectToJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

    public static void main(String[] args) throws SQLException {
        try {
            //step-1. Driver Loading
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Load Successfully");

            //step-2. Connection Establishment
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "santosh");
            System.out.println("Connected Successfully");

            //step-3. Creating statement object to dispatch the SQL cmd to DB
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(("INSERT INTO emp VALUES(111,'Ramesh',10000)"));

            //step-4. Close the connection
            con.close();
            System.out.println(n + " Rows Affected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
