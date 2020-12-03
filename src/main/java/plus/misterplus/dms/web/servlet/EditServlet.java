package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.crypto.Encryption;
import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;
import plus.misterplus.dms.sql.query.advanced.EditQuery;
import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String spass = Encryption.md5(req.getParameter("spass"));
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

    protected void payFee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        String date = req.getParameter("date");
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        try {
            Date cdate = sdf.parse(date);
            boolean success = EditQuery.updateFee(cdate, sno, true);
            if (success) {
                resp.setStatus(200);
            }
            else {
                resp.setStatus(621); //更新失败
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void newFee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double famount = Double.parseDouble(req.getParameter("famount"));
        String ftype = req.getParameter("ftype");
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        boolean success = EditQuery.insertFee(new Date(), famount, ftype, false, sno);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(622); //插入失败
        }
    }

    protected void insertNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String adno = TokenHelper.parseToken(token).getUsername();
        String ntitle = req.getParameter("ntitle");
        String ncontent = req.getParameter("ncontent");
        boolean success = EditQuery.insertNotice(new Date(), adno, ntitle, ncontent);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(622);
        }
    }

    protected void insertCleanContest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String adno = TokenHelper.parseToken(token).getUsername();
        String dbno = req.getParameter("dbno");
        String dbd = req.getParameter("dbd");
        String drbno = req.getParameter("drbno");
        double cscore = Double.parseDouble(req.getParameter("cscore"));
        String date = req.getParameter("date");
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        try {
            Date cdate = sdf.parse(date);
            boolean success = EditQuery.insertCleanContest(cdate, dbno, dbd, drbno, cscore);
            if (success) {
                resp.setStatus(200);
            }
            else {
                resp.setStatus(622);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            resp.setStatus(622);
        }
    }

    protected void resetStudentPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        boolean success = EditQuery.resetStudentPass(sno);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(622);
        }
    }

    protected void insertAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adno = req.getParameter("adno");
        String adpass = Encryption.md5(req.getParameter("adpass"));
        String adname = req.getParameter("adname");
        boolean success = EditQuery.insertAdmin(adno, adpass, adname);
        if (success) {
            resp.setStatus(200);
        }
        else {
            resp.setStatus(622);
        }
    }
}
