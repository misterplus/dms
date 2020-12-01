package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.FeeDao;
import plus.misterplus.dms.sql.entity.Fee;

import java.util.Date;
import java.util.List;

public class FeeDaoImpl extends BaseDao implements FeeDao {
    private static final FeeDaoImpl instance = new FeeDaoImpl();

    public static FeeDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int insertFee(Date fdate, double famount, String ftype, boolean fpaid, String sno) {
        String sql = "insert into fees (dbno, dbd, drbno, fdate, famount, ftype, fpaid) select dbno, dbd, drbno, ?, ?, ? from student where sno = ?";
        return insert(sql, fdate, famount, ftype, fpaid, sno);
    }

    @Override
    public List<Fee> selectFeesWithSno(String sno) {
        String sql = "select f.* from fees f, student s where s.sno = ? and f.dbno = s.dbno and f.dbd = s.dbd and f.drbno = s.drbno";
        return selectMultiple(Fee.class, sql, sno);
    }

    @Override
    public int updateFee(Date fdate, String sno, boolean fpaid) {
        String sql = "update f set f.fpaid = ? from (select f.* from fees f, student s where f.fdate = ? and s.sno = ? and f.dbno = s.dbno and f.dbd = s.dbd and f.drbno = s.drbno) as f";
        return update(sql, fpaid, fdate, sno);
    }
}
