package plus.misterplus.dms.entity;

public class DormitoryRoom {
    private int dbno, drbd, drbno, dmno;

    public DormitoryRoom(int dbno, int drbd, int drbno) {
        this.dbno = dbno;
        this.drbd = drbd;
        this.drbno = drbno;
        this.dmno = -1;
    }
}
