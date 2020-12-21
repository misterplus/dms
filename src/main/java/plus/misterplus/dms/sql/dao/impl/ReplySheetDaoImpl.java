package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.ReplySheetDao;
import plus.misterplus.dms.sql.entity.ReplySheet;

import java.util.List;

public class ReplySheetDaoImpl extends BaseDao implements ReplySheetDao {

    private static final ReplySheetDaoImpl instance = new ReplySheetDaoImpl();

    public static ReplySheetDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<ReplySheet> selectReplySheets() {
        String sql = "select * from resheet";
        return selectMultiple(ReplySheet.class, sql);
    }

    @Override
    public List<ReplySheet> selectReplySheetWithDorm(String dbno, String dbd, String drbno) {
        String sql = "select * from resheet where reno in (select reno from rsheet where dbno = ? and dbd = ? and drbno = ?)";
        return selectMultiple(ReplySheet.class, sql, dbno, dbd, drbno);
    }

    @Override
    public List<ReplySheet> selectReplySheetWithinTime(String start, String end) {
        String sql = "select reno from rsheet where rdate >= start and rdate <= end";
        return selectMultiple(ReplySheet.class, sql, start, end);
    }
}