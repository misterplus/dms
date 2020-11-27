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
    private String dbno, dbd, drbno;
    private double famount;
    private boolean ftype; //true 水费 false 电费
}
