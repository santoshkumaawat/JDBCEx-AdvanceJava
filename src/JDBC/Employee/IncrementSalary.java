package JDBC.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class IncrementSalary {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID");
        int eid = sc.nextInt();
        System.out.println("Enter Increment Amount");
        int amnt = sc.nextInt();

        String sql = "UPDATE empdata SET esalary=esalary+? WHERE eid=?";
        Connection con = ConnectionProvider.connect();
        //to run parameterized queries we need preparedStatement.
        PreparedStatement ps = con.prepareStatement(sql);
        //setting the values for all parameters
        ps.setInt(1, amnt);
        ps.setInt(2, eid);
        int n = ps.executeUpdate();
        con.close();
        System.out.println(n + " Rows Modified");
    }
}
