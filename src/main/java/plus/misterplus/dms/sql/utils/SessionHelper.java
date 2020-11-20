package plus.misterplus.dms.sql.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionHelper {

    public static Map<String, HttpSession> sessions = new HashMap<>();

    public static boolean isSessionInvalid(HttpSession session) {
        try {
            session.getCreationTime();
            return false;
        } catch (IllegalStateException e) {
            return true;
        }
    }
}
