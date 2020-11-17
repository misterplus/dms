package plus.misterplus.dms.sql.utils;

import java.util.Collections;

public class CodeHelper {
    public static String getQuestionMarks(int count) {
        return String.join(",", Collections.nCopies(count,"?"));
    }

    public static String escape(String original) {
        return original;
    }
}
