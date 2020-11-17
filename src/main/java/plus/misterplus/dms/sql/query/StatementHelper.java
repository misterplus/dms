package plus.misterplus.dms.sql.query;

import plus.misterplus.dms.sql.utils.Linker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static plus.misterplus.dms.sql.utils.CodeHelper.getQuestionMarks;

public class StatementHelper {
    public static PreparedStatement prepSelectAll(String table) throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement(String.format("select * from %s", table));
    }

    public static PreparedStatement prepSelectOnly(String table, String[] attributes) throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement(String.format("select (%s) from %s", String.join(",", attributes), table));
    }

    public static PreparedStatement prepSelectOnlyWith(String table, String attribute, boolean equals) throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement(String.format("select * from %s where %s %s ?", table, attribute, equals ? "in" : "like"));
    }

    public static PreparedStatement prepInsert(String table, int args) throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement(String.format("insert into %s values (%s)", table, getQuestionMarks(args)));
    }

    public static PreparedStatement prepInsertOnly(String table, String[] attributes) throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement(String.format("insert into %s(%s) values (%s)", table, String.join(",", attributes), getQuestionMarks(attributes.length)));
    }
}
