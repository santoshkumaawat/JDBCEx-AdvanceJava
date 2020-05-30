package JDBC.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayData {

    public static void main(String[] args) throws Exception {
        Connection con = ConnectionProvider.connect();
        String sql = "SELECT eid, ename, esalary, esalary*12 as yrSal FROM empdata";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ename") + "|" + rs.getString("eid") + "|" + rs.getString("esalary") + "|" + rs.getString("yrSal"));
        }
        con.close();
    }
}
