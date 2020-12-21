package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.CleanContest;

import java.util.Date;
import java.util.List;

public interface CleanContestDao {
    public List<CleanContest> selectCleanContestsWithSno(String sno);
    public int insertCleanContest(Date cdate, String dbno, String dbd, String drbno, double cscore);
    public List<CleanContest> selectContests();
    public List<CleanContest> selectCleanContestsWithDorm(String dbno, String dbd, String drbno);
    public List<CleanContest> selectCleanContestsWithinTime(String start, String end);
}
