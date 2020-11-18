package plus.misterplus.dms.sql.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

public class CodeHelper {
    public static String getQuestionMarks(int count) {
        return String.join(",", Collections.nCopies(count,"?"));
    }

    public static void close(Connection db) {
        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
