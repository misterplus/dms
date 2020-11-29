package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.entity.*;
import plus.misterplus.dms.sql.query.advanced.InfoQuery;
import plus.misterplus.dms.sql.utils.GsonHelper;
import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/api/infoServlet")
public class InfoServlet extends BaseServlet {
    protected void selectDormRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbno = req.getParameter("dbno");
        String dbd = req.getParameter("dbd");
        String drbno = req.getParameter("drbno");
        DormRoom dormRoom = InfoQuery.selectDormRoom(dbno, dbd, drbno);
        if (dormRoom != null)
            resp.getWriter().write(GsonHelper.toJson(dormRoom));
        else
            resp.setStatus(620); //查询失败
    }

    protected void selectRepairSheetsWithSno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        List<RepairSheet> sheets = InfoQuery.selectRepairSheetsWithSno(sno);
        if (sheets != null)
            resp.getWriter().write(GsonHelper.toJson(sheets));
        else
            resp.setStatus(620); //查询失败
    }

    protected void selectFeesWithSno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        List<Fee> fees = InfoQuery.selectFeesWithSno(sno);
        if (fees != null)
            resp.getWriter().write(GsonHelper.toJson(fees));
        else
            resp.setStatus(620); //查询失败
    }

    protected void selectNotices(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Notice> notices = InfoQuery.selectNotices();
        if (notices != null)
            resp.getWriter().write(GsonHelper.toJson(notices));
        else
            resp.setStatus(620);
    }

    protected void selectCleanContestsWithSno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        List<CleanContest> cleanContests = InfoQuery.selectCleanContestsWithSno(sno);
        if (cleanContests != null)
            resp.getWriter().write(GsonHelper.toJson(cleanContests));
        else
            resp.setStatus(620);
    }

    protected void selectStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = InfoQuery.selectStudents();
        if (students != null)
            resp.getWriter().write(GsonHelper.toJson(students));
        else
            resp.setStatus(620);
    }

    protected void selectStudentDorm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        DormRoom dormRoom = InfoQuery.selectStudentDorm(sno);
        if (dormRoom != null)
            resp.getWriter().write(GsonHelper.toJson(dormRoom));
        else
            resp.setStatus(620);
    }
}
