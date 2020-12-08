package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.DormBuilding;

public interface DormBuildingDao {
    public DormBuilding selectDormBuilding(String dbno, String dbd);
    public int insertDormBuilding(String dbno, String dbd);
}
