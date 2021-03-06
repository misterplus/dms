package plus.misterplus.dms.sql.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Linker {

    private Connection db;

    private Linker() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.db = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=demo", "sa", "dmsadminpass");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            this.db = null;
        }
    }

    public static Connection getDb() {
        return new Linker().db;
    }
}
