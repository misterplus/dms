package plus.misterplus.dms.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormRoom {
    private String drbno, dbno, dbd, dmno;
    private int dcap;
}
