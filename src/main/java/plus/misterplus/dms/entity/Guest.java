package plus.misterplus.dms.entity;

import java.util.Date;

public class Guest {
    private String gname;
    private Date gdate;
    private long gphone;
    private int gbno, gbd, gdno;
    private boolean gtype;

    public Guest(String gname, Date gdate, long gphone, int gbno, int gbd, int gdno, boolean gtype) {
        this.gname = gname;
        this.gdate = gdate;
        this.gphone = gphone;
        this.gbno = gbno;
        this.gbd = gbd;
        this.gdno = gdno;
        this.gtype = gtype;
    }
}
