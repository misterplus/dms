package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Fee;

import java.util.Date;
import java.util.List;

public interface FeeDao {
    public int insertFee(Date fdate, double famount, boolean ftype, String sno);
    public List<Fee> selectFeesWithSno(String sno);
}
