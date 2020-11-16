package plus.misterplus.dms.sql.query;

import plus.misterplus.dms.sql.utils.Linker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

public class StatementHelper {
    public static PreparedStatement prepSelectAll() throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement("select * from ?");
    }

    public static PreparedStatement prepSelectOnly() throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement("select * from ? where ? like ?");
    }

    public static PreparedStatement prepInsert(int args) throws SQLException {
        Connection db = Linker.getDb();
        return db.prepareStatement(String.format("insert into ? values (%s)", String.join(",", Collections.nCopies(args,"?"))));
    }
}
