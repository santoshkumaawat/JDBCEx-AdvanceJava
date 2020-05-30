package JDBC.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetDeletionEx {

    public static void main(String[] args) throws Exception {
        try (Connection con = ConnectionProvider.connect()) {
            String sql = "SELECT * FROM empdata";
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
            }
            System.out.println("-----------------------");

            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to delete row from table (enter 1 to yes)");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter Row No.");
                int row = sc.nextInt();
                //deletin row
                //1. move the cursor
                rs.absolute(row);
                //2. delete the row
                rs.deleteRow();

                System.out.println("Row deleted");

                System.out.println("Updated ResultSet....");
                System.out.println("-----------------------");
                rs.beforeFirst();
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
                }
            } else {
                System.out.println("You opted not to delete.....");
            }
        }
    }
}
