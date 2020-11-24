package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Student;

public interface StudentDao {
    public int insertStudent(Student student);
    public Student selectStudentWithSno(String sno);
    public int updateStudentName(String sno, String sname);
    public int updateStudentPass(String sno, String spass);
    public int updateStudentDorm(String sno, String dbno, String dbd, String drbno);
}
