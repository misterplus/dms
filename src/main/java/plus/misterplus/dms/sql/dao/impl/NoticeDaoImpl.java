package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.NoticeDao;
import plus.misterplus.dms.sql.entity.Notice;

import java.util.Date;
import java.util.List;

public class NoticeDaoImpl extends BaseDao implements NoticeDao {

    private static final NoticeDaoImpl instance = new NoticeDaoImpl();

    public static NoticeDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Notice> selectNotices() {
        String sql = "select * from notice";
        return selectMultiple(Notice.class, sql);
    }

    @Override
    public int insertNotice(Date ntime, String adno, String ntitle, String ncontent) {
        String sql = "insert into notice(ntime, adno, ntitle, ncontent) values(?,?,?,?)";
        return insert(sql, ntime, adno, ntitle, ncontent);
    }
}
