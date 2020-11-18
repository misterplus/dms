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
}
