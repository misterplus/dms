package plus.misterplus.dms.sql;

import plus.misterplus.dms.sql.utils.Linker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection c = Linker.getDb();
        PreparedStatement s = c.prepareStatement("insert into student(sno,spass) values(?,?)");
        s.setString(1, "19051520");
        s.setString(2, "aaaaaaaaaaaaaaaa");
        s.executeUpdate();
    }
}
