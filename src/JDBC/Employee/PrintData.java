package JDBC.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintData {

    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM empdata";
        Connection con = ConnectionProvider.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            /*String str = getAll(rs);
            System.out.println(str);*/

            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            int i = rs.getInt(3);
            int pkg = i * 12;
            System.out.println(s1 + "|" + s2 + "|" + i + "|" + pkg);
        }
        con.close();
    }

    public static String getAll(ResultSet rs) throws SQLException {
        String res = rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3);
        return res;
    }
}
