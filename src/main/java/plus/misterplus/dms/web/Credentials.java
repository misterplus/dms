package plus.misterplus.dms.web;

public class Credentials {
    private final String username;
    private final String password;
    private final String usertype;

    public Credentials(String username, String password, String usertype) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", username, password, usertype);
    }
}
