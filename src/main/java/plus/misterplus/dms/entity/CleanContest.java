package plus.misterplus.dms.entity;

import java.util.Date;

public class CleanContest {
    private Date cdate;
    private int sbno, sbd, sdno;
    private double cscore;

    public CleanContest(Date cdate, int sbno, int sbd, int sdno, double cscore) {
        this.cdate = cdate;
        this.sbno = sbno;
        this.sbd = sbd;
        this.sdno = sdno;
        this.cscore = cscore;
    }
}
