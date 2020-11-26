package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.query.advanced.EditQuery;
import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/editServlet")
public class EditServlet extends BaseServlet {

    protected void updateStudentName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        String sname = req.getParameter("sname");
        boolean success = EditQuery.updateStudentName(sno, sname);
        if (success)
            resp.setStatus(200);
        else
            resp.setStatus(621); //更新失败
    }

    protected void updateStudentPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        String spass = req.getParameter("spass");
        boolean success = EditQuery.updateStudentPass(sno, spass);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(621); //更新失败
        }
    }

    protected void updateStudentDorm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        String dbno = req.getParameter("dbno");
        String dbd = req.getParameter("dbd");
        String drbno = req.getParameter("drbno");
        boolean success = EditQuery.updateStudentDorm(sno, dbno, dbd, drbno);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(621); //更新失败
        }
    }

    protected void insertRepairSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String rtype = req.getParameter("rtype");
        String rcon = req.getParameter("rcon");
        String sno = TokenHelper.parseToken(token).getUsername();
        boolean success = EditQuery.insertRepairSheet(rcon, rtype, "待分配", sno);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(622); //插入失败
        }
    }
}
