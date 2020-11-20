package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.query.advanced.UserQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        boolean register = "register".equals(request.getParameter("register"));
        boolean cache = "cache".equals(request.getParameter("cache"));
        boolean success = UserQuery.login(username, password, usertype, register, cache, request, response);
        if (success)
            response.sendRedirect("/user/main.jsp");
    }
}
