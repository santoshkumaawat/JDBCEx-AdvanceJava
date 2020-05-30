package JDBC.DDL;

import JDBC.Employee.ConnectionProvider;
import java.sql.Connection;
import java.sql.Statement;

public class CreateTableEx {

    public static void main(String[] args) throws Exception {
        String sql = "CREATE TABLE trial(id INT PRIMARY KEY,name VARCHAR(25))";
        //String sql = "DROP TABLE trial";
        Connection con = ConnectionProvider.connect();
        System.out.println("Connection Established");
        Statement st = con.createStatement();
        int n = st.executeUpdate(sql);
        con.close();
        System.out.println(n);
    }
}
