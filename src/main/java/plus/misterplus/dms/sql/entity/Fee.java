package plus.misterplus.dms.sql.entity;

import java.util.Date;

public class Fee {
    private Date fdate;
    private Double famount;
    private boolean ftype;
    private int fbno, fbd, fdno;

    public Fee(Date fdate, Double famount, boolean ftype, int fbno, int fbd, int fdno) {
        this.fdate = fdate;
        this.famount = famount;
        this.ftype = ftype;
        this.fbno = fbno;
        this.fbd = fbd;
        this.fdno = fdno;
    }
}
