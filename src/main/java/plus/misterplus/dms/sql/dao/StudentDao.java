package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.DormRoom;
import plus.misterplus.dms.sql.entity.Student;

import java.util.List;

public interface StudentDao {
    public int insertStudent(Student student);
    public Student selectStudentWithSno(String sno);
    public int updateStudentName(String sno, String sname);
    public int updateStudentPass(String sno, String spass);
    public int updateStudentDorm(String sno, String dbno, String dbd, String drbno);
    public DormRoom selectStudentDorm(String sno);
    public List<Student> selectStudents();
}
