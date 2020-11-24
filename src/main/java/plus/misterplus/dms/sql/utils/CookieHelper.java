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
        if (cookies == null)
            return cookieMap;
        for (Cookie c : cookies) {
            cookieMap.put(c.getName(), c.getValue());
        }
        return cookieMap;
    }

    public static void saveTokenToCookie(HttpServletResponse resp, String token, boolean persist) {
        Cookie cookie = new Cookie("dms_token", token);
        if (persist)
            cookie.setMaxAge(EXPIRE_TIME);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    public static void removeInvalidTokenFromCookie(HttpServletResponse resp) {
        Cookie cookie = new Cookie("dms_token", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }
}
