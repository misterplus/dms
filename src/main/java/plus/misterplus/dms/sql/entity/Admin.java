package plus.misterplus.dms.sql.entity;

public class Admin {
    private int adno;
    private String adpass, adname;

    public Admin(int adno, String adpass, String adname) {
        this.adno = adno;
        this.adpass = adpass;
        this.adname = adname;
    }
}
