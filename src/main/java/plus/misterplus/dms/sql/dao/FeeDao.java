package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Fee;

import java.util.Date;
import java.util.List;

public interface FeeDao {
    public int insertFee(Date fdate, double famount, String ftype, boolean fpaid, String sno);
    public List<Fee> selectFeesWithSno(String sno);
    public int updateFee(long fno, String sno, boolean fpaid);
    public List<Fee> selectFees();
    public int insertFee(Date fdate, double famount, String ftype, boolean fpaid, String dbno, String dbd, String drbno);
}
