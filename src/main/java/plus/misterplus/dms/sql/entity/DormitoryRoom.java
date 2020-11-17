package plus.misterplus.dms.sql.entity;

public class DormitoryRoom {
    private int dbno, drbd, drbno, dmno, dcap;

    public DormitoryRoom(int dbno, int drbd, int drbno, int dcap) {
        this.dbno = dbno;
        this.drbd = drbd;
        this.drbno = drbno;
        this.dmno = -1;
        this.dcap = dcap;
    }
}
