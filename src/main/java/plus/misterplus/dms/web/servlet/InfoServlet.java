package plus.misterplus.dms.web.servlet;

import plus.misterplus.dms.sql.entity.DormRoom;
import plus.misterplus.dms.sql.query.advanced.InfoQuery;
import plus.misterplus.dms.sql.utils.GsonHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            resp.setStatus(520); //查询失败
    }
}
