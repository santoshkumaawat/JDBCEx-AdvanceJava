package JDBC.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetInsertionEx {

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
            System.out.println("Do you want to add more data in table (enter 1 to yes)");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter employee id");
                int id = sc.nextInt();
                System.out.println("Enter employee name");
                String name = sc.next();
                System.out.println("Enter employee salary");
                int sal = sc.nextInt();

                //Inserting row using resultset
                //Step 1. create an empty row
                rs.moveToInsertRow();
                //step 2. modify the columns of new row
                rs.updateInt(1, id);
                rs.updateString(2, name);
                rs.updateInt(3, sal);
                //step 3. save new row to DB
                rs.insertRow();
                System.out.println("-----------------------");
                System.out.println("New Row Added Successfully");
                System.out.println("Updated ResultSet....");
                System.out.println("-----------------------");
                rs.beforeFirst();
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
                }
            } else {
                System.out.println("You opted not to add.....");
            }
        }
    }
}
