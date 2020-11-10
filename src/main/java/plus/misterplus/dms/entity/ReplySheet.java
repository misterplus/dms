package plus.misterplus.dms.entity;

public class ReplySheet {
    private long reno;
    private String reman, rereason, restatus;
    private double recost;
    private int remanno;

    public ReplySheet(long reno, String reman, String rereason, String restatus, double recost, int remanno) {
        this.reno = reno;
        this.reman = reman;
        this.rereason = rereason;
        this.restatus = restatus;
        this.recost = recost;
        this.remanno = remanno;
    }
}
