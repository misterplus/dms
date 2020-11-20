package plus.misterplus.dms.sql.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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

    public static String getCurrentJSP(HttpServletRequest request) {
        String[] s = request.getServletPath().split("/");
        return s[s.length - 1];
    }

    public static void reset(HttpServletRequest request, HttpServletResponse response) {
        List<String> pageForReset = Arrays.asList("index.jsp", "auth.jsp", "register.jsp");
        try {
            if (pageForReset.contains(getCurrentJSP(request))) {
                response.sendRedirect("/user/main.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void reset(HttpServletResponse response) {
        try {
            response.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}