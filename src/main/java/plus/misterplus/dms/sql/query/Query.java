package plus.misterplus.dms.sql.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {

    /**
     * select某表中所有的内容
     * @param table 要select的表名
     * @return select的结果
     * @throws SQLException 操作可能失败抛出的异常
     */
    public static ResultSet selectAll(String table) throws SQLException {
        PreparedStatement ps = StatementHelper.prepSelectAll(table);
        return ps.executeQuery();
    }

    /**
     * select某表，只选取某些属性
     * @param table 要select的表名
     * @param attributes 要select的属性
     * @return select的结果
     * @throws SQLException 操作失败可能抛出的异常
     */
    public static ResultSet selectOnly(String table, String[] attributes) throws SQLException {
        PreparedStatement ps = StatementHelper.prepSelectOnly(table, attributes);
        return ps.executeQuery();
    }

    public static ResultSet selectOnlyWith(String table, String attribute, String searchFor, boolean equals) throws SQLException {
        PreparedStatement ps = StatementHelper.prepSelectOnlyWith(table, attribute, equals);
        ps.setString(1, equals ? searchFor : String.join(searchFor, new String[]{"%", "%"}));
        return ps.executeQuery();
    }

    public static ResultSet selectOnlyStartWith(String table, String attribute, String searchFor, boolean endWith) throws SQLException {
        PreparedStatement ps = StatementHelper.prepSelectOnlyWith(table, attribute, false);
        ps.setString(1, endWith ? "%" + searchFor : searchFor + "%");
        return ps.executeQuery();
    }

    public static int insert(String table, Object[] values) throws SQLException {
        int length = values.length;
        PreparedStatement ps = StatementHelper.prepInsert(table, length);
        for (int i = 0; i < length; i++) {
            ps.setObject(i + 1, values[i]);
        }
        return ps.executeUpdate();
    }

    public static int insertOnly(String table, String[] attributes, Object[] values) throws SQLException {
        int length = values.length;
        PreparedStatement ps = StatementHelper.prepInsertOnly(table, attributes);
        for (int i = 0; i < length; i++) {
            ps.setObject(i + 1, values[i]);
        }
        return ps.executeUpdate();
    }
}
