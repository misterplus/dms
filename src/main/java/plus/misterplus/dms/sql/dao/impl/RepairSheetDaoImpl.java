package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.RepairSheetDao;
import plus.misterplus.dms.sql.entity.RepairSheet;

import java.util.List;

public class RepairSheetDaoImpl extends BaseDao implements RepairSheetDao {

    private static final RepairSheetDaoImpl instance = new RepairSheetDaoImpl();

    public static RepairSheetDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int insertRepairSheet(String rcon, String rtype, String rprogress, String sno) {
        String sql = "insert into rsheet (dbno, dbd, drbno, rcon, rtype, rprogress) select dbno, dbd, drbno, ?, ?, ? from student where sno = ?;";
        return insert(sql, rcon, rtype, rprogress, sno);
    }

    @Override
    public int updateRepairSheetReno(long rsno, long reno) {
        String sql = "update rsheet set reno = ? where rsno = ?";
        return update(sql, reno, rsno);
    }

    @Override
    public int updateRepairSheetProgress(long rsno, String rprogress) {
        String sql = "update rsheet set rprogress = ? where rsno = ?";
        return update(sql, rprogress, rsno);
    }

    @Override
    public List<RepairSheet> selectRepairSheetsWithSno(String sno) {
        String sql = "select r.* from rsheet r, student s where s.sno = ? and r.dbno = s.dbno and r.dbd = s.dbd and r.drbno = s.drbno";
        return selectMultiple(RepairSheet.class, sql, sno);
    }


}
