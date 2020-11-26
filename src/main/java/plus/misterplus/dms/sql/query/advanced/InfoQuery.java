package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.impl.DormRoomDaoImpl;
import plus.misterplus.dms.sql.dao.impl.RepairSheetDaoImpl;
import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;
import plus.misterplus.dms.sql.entity.DormRoom;
import plus.misterplus.dms.sql.entity.RepairSheet;

import java.util.List;

public class InfoQuery {
    public static DormRoom selectDormRoom(String dbno, String dbd, String drbno) {
        return DormRoomDaoImpl.getInstance().selectDormRoom(dbno, dbd, drbno);
    }

    public static DormRoom selectStudentDorm(String sno) {
        return StudentDaoImpl.getInstance().selectStudentDorm(sno);
    }

    public static List<RepairSheet> selectRepairSheetsWithSno(String sno) {
        return RepairSheetDaoImpl.getInstance().selectRepairSheetsWithSno(sno);
    }
}
