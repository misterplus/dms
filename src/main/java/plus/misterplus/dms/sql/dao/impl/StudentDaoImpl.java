package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.StudentDao;
import plus.misterplus.dms.sql.entity.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao {

    private static final StudentDaoImpl instance = new StudentDaoImpl();

    public static StudentDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "insert into student values(?,?,?,?,?,?)";
        return insert(sql, student.getSno(), student.getDrbno(), student.getDbno(), student.getDbd(), student.getSpass(), student.getSname());
    }

    @Override
    public Student selectStudentWithSno(String sno) {
        String sql = "select * from student where sno = ?";
        return select(Student.class, sql, sno);
    }

    @Override
    public int updateStudentName(String sno, String sname) {
        String sql = "update student set sname = ? where sno = ?";
        return update(sql, sname, sno);
    }

    @Override
    public int updateStudentPass(String sno, String spass) {
        String sql = "update student set spass = ? where sno = ?";
        return update(sql, spass, sno);
    }

    @Override
    public int updateStudentDorm(String sno, String dbno, String dbd, String drbno) {
        String sql = "update student set dbno = ?, set dbd = ?, set drbno = ? where sno = ?";
        return update(sql, dbno, dbd, drbno, sno);
    }
}
