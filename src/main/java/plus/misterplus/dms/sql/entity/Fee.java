package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fee {
    private Date fdate;
    private String dbno, dbd, drbno, ftype;
    private double famount;
    private long fno;
    private boolean fpaid;
}
