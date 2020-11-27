package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.CleanContest;

import java.util.Date;
import java.util.List;

public interface CleanContestDao {
    public List<CleanContest> selectCleanContestsWithSno(String sno);
    public int insertCleanContest(Date cdate, String dbno, String dbd, String drbno, String adno, double cscore);
}
