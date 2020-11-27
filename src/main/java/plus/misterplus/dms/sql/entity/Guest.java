package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private String gname, dbno, dbd;
    private long gphone;
    private boolean gtype;
    private Date gdate;
}
