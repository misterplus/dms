package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.entity.*;
import plus.misterplus.dms.sql.query.advanced.InfoQuery;
import plus.misterplus.dms.sql.utils.GsonHelper;
import plus.misterplus.dms.sql.utils.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;
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

    protected void selectStudentWithSno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("dms_token");
        String sno = TokenHelper.parseToken(token).getUsername();
        Student student = InfoQuery.selectStudentWithSno(sno);
        if (student != null)
            resp.getWriter().write(GsonHelper.toJson(student));
        else
            resp.setStatus(620);
    }

    protected void selectAdmins(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Admin> admins = InfoQuery.selectAdmins();
        if (admins != null)
            resp.getWriter().write(GsonHelper.toJson(admins));
        else
            resp.setStatus(620);
    }

    protected void selectContests(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CleanContest> contests = InfoQuery.selectContests();
        if (contests != null)
            resp.getWriter().write(GsonHelper.toJson(contests));
        else
            resp.setStatus(620);
    }

    protected void selectDRooms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DormRoom> drooms = InfoQuery.selectDRooms();
        if (drooms != null)
            resp.getWriter().write(GsonHelper.toJson(drooms));
        else
            resp.setStatus(620);
    }

    protected void selectItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = InfoQuery.selectItems();
        if (items != null)
            resp.getWriter().write(GsonHelper.toJson(items));
        else
            resp.setStatus(620);
    }

    protected void selectGuests(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Guest> guests = InfoQuery.selectGuests();
        if (guests != null)
            resp.getWriter().write(GsonHelper.toJson(guests));
        else
            resp.setStatus(620);
    }

    protected void selectDRoomNotFull(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DormRoom> rooms = InfoQuery.selectDRoomNotFull();
        if (rooms != null)
            resp.getWriter().write(GsonHelper.toJson(rooms));
        else
            resp.setStatus(620);
    }

    protected void selectDormStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbno = req.getParameter("dbno");
        String dbd = req.getParameter("dbd");
        String drbno = req.getParameter("drbno");
        List<Student> students = InfoQuery.selectDormStudents(dbno, dbd, drbno);
        if (students != null)
            resp.getWriter().write(GsonHelper.toJson(students));
        else
            resp.setStatus(620);
    }

    protected void selectFees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Fee> fees = InfoQuery.selectFees();
        if (fees != null)
            resp.getWriter().write(GsonHelper.toJson(fees));
        else
            resp.setStatus(620);
    }
}
