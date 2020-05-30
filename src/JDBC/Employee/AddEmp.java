package JDBC.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddEmp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID");;
        int id = sc.nextInt();
        System.out.println("Enter Employee Name");
        String name = sc.next();
        System.out.println("Enter Employee Salary");
        int sal = sc.nextInt();

        String sql = "INSERT INTO empdata VALUES(?,?,?)";
        Connection con = ConnectionProvider.connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, sal);
        int n = ps.executeUpdate();
        con.close();
        System.out.println(n + " Rows Added");
    }
}
