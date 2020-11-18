package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.crypto.Encryption;
import plus.misterplus.dms.sql.dao.impl.StudentDaoImpl;
import plus.misterplus.dms.sql.entity.Student;

import javax.servlet.http.HttpServletResponse;

public class UserQuery {

    public static boolean login(String username, String password, boolean register, String usertype, boolean cache, HttpServletResponse response) {
        password = Encryption.md5(password);
        boolean success = false;
        if (register) {
            Student student = new Student(username, password);
            int affected = StudentDaoImpl.getInstance().insertStudent(student);
            success = affected != 0;
        }
        else {
            if (usertype.equals("user")) {
                Student student = StudentDaoImpl.getInstance().selectStudentWithSno(username);
                if (student != null)
                    success = student.getSpass().equals(password);
            }
            else {
                //
            }
        }
        if (success && cache) {
            //Cache.saveCredentialsToCookie(username, password, response);
        }
        return success;
    }
}
