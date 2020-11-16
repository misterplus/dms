package plus.misterplus.dms.sql.entity;

import java.util.Date;

public class Item {
    private String iname;
    private int isno, ibno, ibd;
    private boolean itype;
    private Date itime;

    public Item(String iname, int isno, int ibno, int ibd, boolean itype, Date itime) {
        this.iname = iname;
        this.isno = isno;
        this.ibno = ibno;
        this.ibd = ibd;
        this.itype = itype;
        this.itime = itime;
    }
}
