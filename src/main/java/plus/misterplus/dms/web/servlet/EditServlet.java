package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.query.advanced.EditQuery;
import plus.misterplus.dms.sql.query.advanced.InfoQuery;
import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/editServlet")
public class EditServlet extends BaseServlet {

    protected void updateStudentName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("dms_token");
        boolean verified = TokenHelper.verify(token);
        if (verified) {
            String sno = req.getParameter("sno");
            String sname = req.getParameter("sname");
            boolean success = EditQuery.updateStudentName(sno, sname);
            if (success) {
                resp.setStatus(200);
            }
            else {
                resp.setStatus(512); //更新失败
            }
        }
        else {
            resp.setStatus(510); //token无效
        }
    }

    protected void updateStudentPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("dms_token");
        boolean verified = TokenHelper.verify(token);
        if (verified) {
            String sno = req.getParameter("sno");
            String spass = req.getParameter("spass");
            boolean success = EditQuery.updateStudentPass(sno, spass);
            if (success) {
                resp.setStatus(200);
            }
            else {
                resp.setStatus(512); //更新失败
            }
        }
        else {
            resp.setStatus(510); //token无效
        }
    }

    protected void updateStudentDorm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("dms_token");
        boolean verified = TokenHelper.verifyAdmin(token); //需要管理权限
        if (verified) {
            String sno = req.getParameter("sno");
            String dbno = req.getParameter("dbno");
            String dbd = req.getParameter("dbd");
            String drbno = req.getParameter("drbno");
            boolean success = EditQuery.updateStudentDorm(sno, dbno, dbd, drbno);
            if (success) {
                resp.setStatus(200);
            }
            else {
                resp.setStatus(512); //更新失败
            }
        }
        else {
            resp.setStatus(510); //token无效
        }
    }
}
