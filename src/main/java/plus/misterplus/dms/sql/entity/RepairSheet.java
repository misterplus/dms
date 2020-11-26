package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairSheet {
    private long rsno, reno;
    private String dbno, dbd, drbno, rtype, rcon, rprogress;

    public RepairSheet(long rsno, String dbno, String dbd, String drbno, String rtype, String rcon, String rprogress) {
        this.rsno = rsno;
        this.dbno = dbno;
        this.dbd = dbd;
        this.drbno = drbno;
        this.rtype = rtype;
        this.rcon = rcon;
        this.rprogress = rprogress;
    }
}
