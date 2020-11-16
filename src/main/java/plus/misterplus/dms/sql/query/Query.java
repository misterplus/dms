package plus.misterplus.dms.sql.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {

    public static ResultSet selectAll(String table) throws SQLException {
        PreparedStatement ps = StatementHelper.prepSelectAll();
        ps.setString(0, table);
        if (ps.executeUpdate() != 0) {
            return ps.executeQuery();
        }
        return null;
    }

    public static ResultSet selectOnly(String table, String attribute, String searchFor) throws SQLException {
        PreparedStatement ps = StatementHelper.prepSelectOnly();
        ps.setString(0, table);
        ps.setString(1, attribute);
        ps.setString(2, String.join(searchFor, new String[]{"%", "%"}));
        if (ps.executeUpdate() != 0) {
            return ps.executeQuery();
        }
        return null;
    }

    public static void insert(String table, Object[] values) throws SQLException {
        int length = values.length;
        PreparedStatement ps = StatementHelper.prepInsert(length);
        ps.setString(0, table);
        for (int i = 1; i < length + 1; i++) {
            ps.setObject(i, values[i - 1]);
        }
        ps.executeQuery();
    }
}
