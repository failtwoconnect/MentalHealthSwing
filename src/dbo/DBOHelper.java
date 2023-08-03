package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBOHelper {

    static void loadDriver(String driverStr) {
        try {
            Class.forName(driverStr);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    static Connection connect2DB(String connectStr, String userName, String password) {

        String myDB = connectStr;
        Connection DBConn = null;
        try {
            DBConn = DriverManager.getConnection(myDB, userName, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return DBConn;
    }
}
