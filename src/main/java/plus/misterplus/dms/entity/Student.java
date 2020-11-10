package plus.misterplus.dms.entity;

public class Student {

    private int sno, sbno, sbd, sdno;
    private String spass, sname;

    public Student(int sno, String spass, String sname) {
        this.sno = sno;
        this.sbno = -1;
        this.sbd = -1;
        this.sdno = -1;
        this.spass = spass;
        this.sname = sname;
    }
}
