package JDBC.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class SQLProcedureEx {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int eid = sc.nextInt();
        System.out.println("Enter Employee Name");
        String ename = sc.next();
        System.out.println("Enter Employee Salary");
        int esal = sc.nextInt();

        try (Connection con = ConnectionProvider.connect()) {
            CallableStatement cs = con.prepareCall("{call edata(?,?,?)}");
            cs.setInt(1, eid);
            cs.setString(2, ename);
            cs.setInt(3, esal);
            cs.execute();
            System.out.println("Data Stored Successfully using Procedure");
        }
    }
}
