package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.utils.CookieHelper;
import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseServlet extends HttpServlet {

    //null 无需token
    //false 无需管理权限
    //true 需要管理权限
    private static final Map<String, Boolean> access_control = new HashMap<String, Boolean>(){{
        put("login", null);
        put("register", null);
        put("verify", false);
        put("selectDormRoom", false);
        put("updateStudentName", false);
        put("updateStudentPass", false);
        put("updateStudentDorm", true);
        put("insertRepairSheet", false);
        put("selectRepairSheetsWithSno", false);
        put("payFee", false);
        put("useFee", true);
        put("selectFeesWithSno", false);
        put("selectNotices", false);
        put("insertNotice", true);
        put("insertCleanContest", true);
        put("selectCleanContestsWithSno", false);
    }};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String token = req.getHeader("dms_token");
        if (access_control.containsKey(action)) {
            Boolean requireAdmin = access_control.get(action);
            if (requireAdmin == null)
                invoke(req, resp, action);
            else if (requireAdmin) {
                boolean isAdmin = TokenHelper.verifyAdmin(token);
                if (isAdmin)
                    invoke(req, resp, action);
                else
                    resp.setStatus(511); //token权限不足
            }
            else {
                boolean verified = TokenHelper.verify(token);
                if (verified)
                    invoke(req, resp, action);
                else {
                    CookieHelper.removeInvalidTokenFromCookie(resp);
                    resp.setStatus(610); //token无效
                }
            }
        }
        else {
            resp.setStatus(405); //无此方法
        }
    }

    private void invoke(HttpServletRequest req, HttpServletResponse resp, String action) {
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
