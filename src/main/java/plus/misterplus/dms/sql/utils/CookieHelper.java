package plus.misterplus.dms.sql.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieHelper {

    private static final int EXPIRE_TIME = 7 * 24 * 60 * 60;

    public static Map<String, String> loadCookieMap(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String, String> cookieMap = new HashMap<>();
        for (Cookie c : cookies) {
            cookieMap.put(c.getName(), c.getValue());
        }
        return cookieMap;
    }

    public static String getSessionIdFromCookie(HttpServletRequest request) {
        Map<String, String> cookieMap = loadCookieMap(request);
        if (cookieMap.containsKey("dms_session_id")) {
            return cookieMap.get("dms_session_id");
        }
        return null;
    }

    public static void removeSessionIdFromCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("dms_session_id", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void saveSessionIdToCookie(HttpServletRequest request, HttpServletResponse response, boolean persist) {
        Cookie cookie = new Cookie("dms_session_id", request.getSession().getId());
        if (persist)
            cookie.setMaxAge(EXPIRE_TIME);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
