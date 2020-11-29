package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/importServlet")
public class ImportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        boolean isAdmin = TokenHelper.verifyAdmin(token);
        if (isAdmin) {
            //处理上传文件
        }
        else {
            resp.setStatus(511); //权限不足
        }
    }
}
