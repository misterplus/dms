package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.impl.AdminDaoImpl;
import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;
import plus.misterplus.dms.sql.entity.Admin;
import plus.misterplus.dms.sql.entity.Student;

public class LoginQuery {

    public static boolean register(String username, String password) {
        if (!StudentDaoImpl.getInstance().selectStudentWithSno(username).getSpass().equals("                "))
            return false; //已经注册过了
        int affected = StudentDaoImpl.getInstance().updateStudentPass(username, password);
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
                return password.equals(admin.getAdpass());
        }
        return false;
    }
}
