package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;

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
}
