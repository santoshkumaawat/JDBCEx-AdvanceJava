package JDBC.Employee;

import java.sql.Connection;
import java.sql.Statement;

public class RaiseSalary {

    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.connect();
            String sql = "UPDATE empdata SET esalary=esalary+20000";
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(sql);
            con.close();
            System.out.println(n + " Rows Modified");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
