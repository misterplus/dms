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
        String sql = "exec selectCleanContestsWithSno ?";
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

    @Override
    public List<CleanContest> selectCleanContestsWithDorm(String dbno, String dbd, String drbno) {
        String sql = "select * from ccontest where dbno = ? and dbd = ? and drbno = ?";
        return selectMultiple(CleanContest.class, sql, dbno, dbd, drbno);
    }

    @Override
    public List<CleanContest> selectCleanContestsWithinTime(String start, String end) {
        String sql = "select * from ccontest where cdate >= start and cdate <= end";
        return selectMultiple(CleanContest.class, sql, start ,end);
    }
}
