package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.crypto.Encryption;
import plus.misterplus.dms.sql.query.Query;
import plus.misterplus.dms.sql.utils.CodeHelper;
import plus.misterplus.dms.web.Cache;

import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQuery {

    private static final String[] TABLE_USERS = {"student", "admin"};
    private static final String[] ATTRIBUTES_USERNAME = {"sno", "adno"};
    private static final String[] ATTRIBUTES_PASSWORD = {"spass", "adpass"};

    public static boolean login(String username, String password, boolean register, boolean isAdmin, boolean cache, HttpServletResponse response) {
        password = Encryption.md5(password);
        int admin = isAdmin ? 1 : 0;
        boolean success = false;
        try {
            if (register) {
                int affected = Query.insertOnly(TABLE_USERS[admin], new String[]{ATTRIBUTES_USERNAME[admin], ATTRIBUTES_PASSWORD[admin]}, new String[]{username, password});
                success = affected != 0;
            }
            else {
                ResultSet rs = Query.selectOnlyWith(TABLE_USERS[admin], ATTRIBUTES_USERNAME[admin], username, true);
                if (rs != null && rs.next()) {
                    success = rs.getString(ATTRIBUTES_PASSWORD[admin]).equals(password);
                }
            }
            if (success && cache) {
                Cache.saveCredentialsToCookie(username, password, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
