package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.CleanContestDao;
import plus.misterplus.dms.sql.entity.CleanContest;

import java.util.Date;
import java.util.List;

public class CleanContestDaoImpl extends BaseDao implements CleanContestDao {

    private static final CleanContestDaoImpl instance = new CleanContestDaoImpl();

    public static CleanContestDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<CleanContest> selectCleanContestsWithSno(String sno) {
        String sql = "select c.* from ccontest c, student s where s.sno = ? and c.dbno = s.dbno and c.dbd = s.dbd and c.drbno = s.drbno order by c.cdate desc";
        return selectMultiple(CleanContest.class, sql, sno);
    }

    @Override
    public int insertCleanContest(Date cdate, String dbno, String dbd, String drbno, double cscore) {
        String sql = "insert into ccontest(cdate, dbno, dbd, drbno, cscore) values(?,?,?,?,?)";
        return insert(sql, cdate, dbno, dbd, drbno, cscore);
    }

    @Override
    public List<CleanContest> selectContests() {
        String sql = "select * from ccontest";
        return selectMultiple(CleanContest.class, sql);
    }
}
