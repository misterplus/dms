package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.ReplySheet;

import java.util.List;

public interface ReplySheetDao {
    public List<ReplySheet> selectReplySheets();
    public List<ReplySheet> selectReplySheetWithDorm(String dbno, String dbd, String drbno);
    public List<ReplySheet> selectReplySheetWithinTime(String start, String end);
}
