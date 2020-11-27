package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Date itime;
    private String iname, sno, dbno, dbd;
    private boolean itype;
}
