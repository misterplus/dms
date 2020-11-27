package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySheet {
    private long reno, rsno;
    private String reman, remanno, rereason, restatus;
    private double recost;
}
