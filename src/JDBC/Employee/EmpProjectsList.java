package JDBC.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpProjectsList {

    public static void main(String[] args) throws Exception {
        try (Connection con = ConnectionProvider.connect()) {
            Statement stmt = con.createStatement();
            System.out.println("---------------------------------------------");
            String sql = "SELECT eno,ename,sal,projects.pcode,title,cname FROM employees,projects WHERE employees.pcode=projects.pcode";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
            }
            System.out.println("---------------------------------------------");
        }
    }
}
