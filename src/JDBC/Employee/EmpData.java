package JDBC.Employee;

import java.sql.Connection;
import java.sql.Statement;

public class EmpData {

    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.connect();
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(("INSERT INTO empdata VALUES(116,'SHUBHAM',60000)"));
            con.close();
            System.out.println(n + " Rows Affected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
