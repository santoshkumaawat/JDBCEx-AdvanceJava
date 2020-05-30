package JDBC.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class SQLFunctionEx {

    public static void main(String[] args) throws Exception {
        try (Connection con = ConnectionProvider.connect()) {
            CallableStatement cs = con.prepareCall("{?=call getbonus(?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, 111);
            cs.execute();
            int res = cs.getInt(1);
            System.out.println("Bonus : " + res);
        }
    }
}
