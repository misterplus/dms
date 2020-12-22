package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.AdminDao;
import plus.misterplus.dms.sql.dao.impl.*;
import plus.misterplus.dms.sql.entity.Student;

import java.util.Date;

public class EditQuery {
    public static boolean updateStudentName(String sno, String sname) {
        int affected = StudentDaoImpl.getInstance().updateStudentName(sno, sname);
        return affected != 0;
    }

    public static boolean updateStudentPass(String sno, String spass) {
        int affected = StudentDaoImpl.getInstance().updateStudentPass(sno, spass);
        return affected != 0;
    }

    public static boolean updateStudentDorm(String sno, String dbno, String dbd, String drbno) {
        int affected = StudentDaoImpl.getInstance().updateStudentDorm(sno, dbno, dbd, drbno);
        return affected != 0;
    }

    public static boolean insertRepairSheet(String rcon, String rtype, String rprogress, String sno) {
        int affected = RepairSheetDaoImpl.getInstance().insertRepairSheet(rcon, rtype, rprogress, sno);
        return affected != 0;
    }

    public static boolean insertFee(Date fdate, double famount, String ftype, boolean fpaid, String sno) {
        int affected = FeeDaoImpl.getInstance().insertFee(fdate, famount, ftype, fpaid, sno);
        return affected != 0;
    }

    public static boolean insertNotice(Date ntime, String adno, String ntitle, String ncontent) {
        int affected = NoticeDaoImpl.getInstance().insertNotice(ntime, adno, ntitle, ncontent);
        return affected != 0;
    }

    public static boolean insertCleanContest(Date cdate, String dbno, String dbd, String drbno, double cscore) {
        int affected = CleanContestDaoImpl.getInstance().insertCleanContest(cdate, dbno, dbd, drbno, cscore);
        return affected != 0;
    }

    public static boolean resetStudentPass(String sno) {
        int affected = StudentDaoImpl.getInstance().updateStudentPass(sno, "");
        return affected != 0;
    }

    public static boolean insertStudent(Student student) {
        int affected = StudentDaoImpl.getInstance().insertStudent(student);
        return affected != 0;
    }

    public static boolean updateFee(long fno, String sno, boolean fpaid) {
        int affected = FeeDaoImpl.getInstance().updateFee(fno, sno, fpaid);
        return affected != 0;
    }

    public static boolean insertAdmin(String adno, String adpass, String adname) {
        int affected = AdminDaoImpl.getInstance().insertAdmin(adno, adpass, adname);
        return affected != 0;
    }

    public static boolean insertDormBuilding(String dbno, String dbd) {
        int affected = DormBuildingImpl.getInstance().insertDormBuilding(dbno, dbd);
        return affected != 0;
    }

    public static boolean insertDormRoom(String dbno, String dbd, String drbno, int dcap) {
        int affected = DormRoomDaoImpl.getInstance().insertDormRoom(dbno, dbd, drbno, dcap);
        return affected != 0;
    }

    public static boolean newDorm0(String dbno, int height, int rooms) {
        int affected = ProcedureImpl.getInstance().newDorm0(dbno, height, rooms);
        return affected != 0;
    }

    public static boolean newDorm12(String dbno, int height, int rooms) {
        int affected = ProcedureImpl.getInstance().newDorm12(dbno, height, rooms);
        return affected != 0;
    }

    public static boolean newDorm34(String dbno, int height, int rooms) {
        int affected = ProcedureImpl.getInstance().newDorm34(dbno, height, rooms);
        return affected != 0;
    }

    public static boolean updateDormMonitor(String dbno, String dbd, String drbno, String dmno) {
        int affected = DormRoomDaoImpl.getInstance().updateDormMonitor(dbno, dbd, drbno, dmno);
        return affected != 0;
    }

    public static boolean insertFee(Date fdate, double famount, String ftype, boolean fpaid, String dbno, String dbd, String drbno) {
        int affected = FeeDaoImpl.getInstance().insertFee(fdate, famount, ftype, fpaid, dbno, dbd, drbno);
        return affected != 0;
    }

    public static boolean insertItem(String iname, Date itime, String sno, String dbno, String dbd, boolean itype) {
        int affected = ItemDaoImpl.getInstance().insertItem(iname, itime, sno, dbno, dbd, itype);
        return affected != 0;
    }

    public static boolean insertGuest(String gname, Date gdate, String dbno, String dbd, long gphone, boolean gtype) {
        int affected = GuestDaoImpl.getInstance().insertGuest(gname, gdate, dbno, dbd, gphone, gtype);
        return affected != 0;
    }

    public static boolean insertReplySheet(long rsno, String reman, int remanno, String rereason, double recost, String restatus) {
        int affected = ReplySheetDaoImpl.getInstance().insertReplySheet(rsno, reman, remanno, rereason, recost, restatus);
        return affected != 0;
    }

    public static boolean updateRpSheetStatus(long reno, String restatus) {
        int affected = ReplySheetDaoImpl.getInstance().updateRpSheetStatus(reno, restatus);
        return affected != 0;
    }

    public static boolean deleteStudentWithSno(String sno) {
        int affected = StudentDaoImpl.getInstance().deleteStudentWithSno(sno);
        return affected != 0;
    }

    public static boolean deleteDormRoom(String dbno, String dbd, String drbno) {
        int affected = DormRoomDaoImpl.getInstance().deleteDormRoom(dbno, dbd, drbno);
        return affected != 0;
    }

    public static boolean deleteAdmin(String adno) {
        int affected = AdminDaoImpl.getInstance().deleteAdmin(adno);
        return affected != 0;
    }
}
