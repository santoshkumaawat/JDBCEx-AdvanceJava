package JDBC.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowData {

    public static void main(String[] args) throws Exception {
        try (Connection con = ConnectionProvider.connect()) {
            String sql = "SELECT * FROM empdata";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
            }
            System.out.println("--------------------------------------");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
            }
        }
    }
}
