package plus.misterplus.dms.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Cache {

    private static final int MONTH = 30 * 24 * 60 * 60;

    public static void saveCredentialsToCookie(String username, String password, HttpServletResponse response) {
        Cookie c = new Cookie("dms_credentials", username + "," + password);
        c.setMaxAge(MONTH);
        response.addCookie(c);
    }
}