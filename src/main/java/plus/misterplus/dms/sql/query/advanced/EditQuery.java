package plus.misterplus.dms.sql.query.advanced;

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

    public static boolean insertFee(Date fdate, double famount, boolean ftype, String sno) {
        int affected = FeeDaoImpl.getInstance().insertFee(fdate, famount, ftype, sno);
        return affected != 0;
    }

    public static boolean insertNotice(Date ntime, String adno, String ntitle, String ncontent) {
        int affected = NoticeDaoImpl.getInstance().insertNotice(ntime, adno, ntitle, ncontent);
        return affected != 0;
    }

    public static boolean insertCleanContest(Date cdate, String dbno, String dbd, String drbno, String adno, double cscore) {
        int affected = CleanContestDaoImpl.getInstance().insertCleanContest(cdate, dbno, dbd, drbno, adno, cscore);
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
}
