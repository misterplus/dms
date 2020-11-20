package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.crypto.Encryption;
import plus.misterplus.dms.sql.dao.impl.AdminDaoImpl;
import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;
import plus.misterplus.dms.sql.entity.Admin;
import plus.misterplus.dms.sql.entity.Student;
import plus.misterplus.dms.sql.utils.CookieHelper;
import plus.misterplus.dms.sql.utils.SessionHelper;
import plus.misterplus.dms.web.Credentials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserQuery {

    private static boolean registerQuery(String username, String password) {
        Student student = new Student(username, password);
        int affected = StudentDaoImpl.getInstance().insertStudent(student);
        return affected != 0;
    }

    private static boolean loginQuery(Credentials credentials) {
        return loginQuery(credentials.getUsername(), credentials.getPassword(), credentials.getUsertype());
    }

    private static boolean loginQuery(String username, String password, String usertype) {
        if (usertype.equals("user")) {
            Student student = StudentDaoImpl.getInstance().selectStudentWithSno(username);
            if (student != null)
                return password.equals(student.getSpass());
        }
        else if (usertype.equals("admin")) {
            Admin admin = AdminDaoImpl.getInstance().selectAdmin(username);
            if (admin != null)
                return password.equals(admin.getAdno());
        }
        return false;
    }

    public static boolean login(String username, String password, String usertype, boolean register, boolean cache, HttpServletRequest request, HttpServletResponse response) {
        password = Encryption.md5(password);
        Credentials credentials = new Credentials(username, password, usertype);
        boolean success;
        if (register)
            return registerQuery(username, password);
        else
            success = loginQuery(credentials);
        if (success) {
            HttpSession session = request.getSession();
            credentials.saveToSession(session);
            CookieHelper.saveSessionIdToCookie(request, response, cache);
            SessionHelper.sessions.put(session.getId(), session);
            //session.setMaxInactiveInterval(5);
        }
        return success;
    }

    public static HttpSession loginWithSavedCredentials(HttpServletRequest request, HttpServletResponse response) {
        String id = CookieHelper.getSessionIdFromCookie(request);
        HttpSession session = SessionHelper.sessions.get(id);
        if (session != null && !SessionHelper.isSessionInvalid(session)) {
            Credentials credentials = Credentials.loadFromSession(session);
            if (loginQuery(credentials))
                return session;
        }
        CookieHelper.removeSessionIdFromCookie(response);
        SessionHelper.sessions.remove(id);
        return null;
    }
}
