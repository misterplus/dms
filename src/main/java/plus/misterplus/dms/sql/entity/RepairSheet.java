package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairSheet {
    private long rsno, reno;
    private String dbno, dbd, drbno, rtype, rcon, rprogress;
    private Date rdate;
}
