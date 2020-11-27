package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Notice;

import java.util.Date;
import java.util.List;

public interface NoticeDao {
    public List<Notice> selectNotices();
    public int insertNotice(Date ntime, String adno, String ntitle, String ncontent);
}
