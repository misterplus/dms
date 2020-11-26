package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.RepairSheet;

import java.util.List;

public interface RepairSheetDao {
    public int insertRepairSheet(String rcon, String rtype, String rprogress, String sno);
    public int updateRepairSheetReno(long rsno, long reno);
    public int updateRepairSheetProgress(long rsno, String rprogress);
    public List<RepairSheet> selectRepairSheetsWithSno(String sno);
}
