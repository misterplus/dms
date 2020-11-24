package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.impl.AdminDaoImpl;
import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;
import plus.misterplus.dms.sql.entity.Admin;
import plus.misterplus.dms.sql.entity.Student;

public class LoginQuery {

    public static boolean register(String username, String password) {
        Student student = new Student(username, password);
        int affected = StudentDaoImpl.getInstance().insertStudent(student);
        return affected != 0;
    }

    public static boolean login(String username, String password, String usertype) {
        if (usertype.equals("user")) {
            Student student = StudentDaoImpl.getInstance().selectStudentWithSno(username);
            if (student != null)
                return password.equals(student.getSpass());
        }
        else if (usertype.equals("admin")) {
            Admin admin = AdminDaoImpl.getInstance().selectAdmin(username);
            if (admin != null)
                return password.equals(admin.getAdno());
        }
        return false;
    }
}
