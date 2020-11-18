package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Student;

public interface StudentDao {
    public int insertStudent(Student student);
    public Student selectStudentWithSno(String sno);
}
