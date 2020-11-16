package plus.misterplus.dms.sql.entity;

public class RepairSheet {
    private long rsno, reno;
    private String rtype, rcon, rprogress, rinfo;
    private int rbno, rbd, rdno;

    public RepairSheet(long rsno, String rtype, String rcon, String rprogress, String rinfo, int rbno, int rbd, int rdno) {
        this.rsno = rsno;
        this.rtype = rtype;
        this.rcon = rcon;
        this.rprogress = rprogress;
        this.rinfo = rinfo;
        this.rbno = rbno;
        this.rbd = rbd;
        this.rdno = rdno;
    }
}
