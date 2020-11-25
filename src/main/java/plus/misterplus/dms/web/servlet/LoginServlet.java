package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.crypto.Encryption;
import plus.misterplus.dms.sql.query.advanced.LoginQuery;
import plus.misterplus.dms.sql.utils.CookieHelper;
import plus.misterplus.dms.sql.utils.GsonHelper;
import plus.misterplus.dms.sql.utils.TokenHelper;
import plus.misterplus.dms.web.Credentials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/loginServlet")
public class LoginServlet extends BaseServlet {

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = Encryption.md5(req.getParameter("password"));
        String usertype = req.getParameter("usertype");
        boolean cache = "cache".equals(req.getParameter("cache"));
        boolean success = LoginQuery.login(username, password, usertype);
        if (success) {
            String token = TokenHelper.createToken(username, usertype);
            CookieHelper.saveTokenToCookie(resp, token, cache);
            resp.sendRedirect("/user/main.jsp");
        }
        else {
            req.setAttribute("message", "用户名或密码错误！");
            req.getRequestDispatcher("/login/info.jsp").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = Encryption.md5(req.getParameter("password"));
        boolean success = LoginQuery.register(username, password);
        if (success) {
            req.setAttribute("message", "注册成功！");
            req.getRequestDispatcher("/login/info.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("message", "该学号已注册！");
            req.getRequestDispatcher("/login/register.jsp").forward(req, resp);
        }
    }

    protected void verify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("dms_token");
        Credentials credentials = TokenHelper.parseToken(token);
        resp.getWriter().write(GsonHelper.toJson(credentials));//返回凭据json
    }
}