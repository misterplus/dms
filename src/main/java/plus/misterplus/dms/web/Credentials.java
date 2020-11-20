package plus.misterplus.dms.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.http.HttpSession;

@Data
@AllArgsConstructor
public class Credentials {

    private final String username;
    private final String password;
    private final String usertype;

    @Override
    public String toString() {
        return String.format("%s,%s,%s", username, password, usertype);
    }

    public static Credentials loadFromSession(HttpSession session) {
        return (Credentials) session.getAttribute("dms_credentials");
    }

    public void saveToSession(HttpSession session) {
        session.setAttribute("dms_credentials", this);
    }

    public String getActualUserType() {
        return this.usertype.equals("user") ? "学生" : "管理";
    }
}
