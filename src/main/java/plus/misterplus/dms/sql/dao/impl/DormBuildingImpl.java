package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.DormBuildingDao;
import plus.misterplus.dms.sql.entity.DormBuilding;

public class DormBuildingImpl extends BaseDao implements DormBuildingDao {

    private static final DormBuildingImpl instance = new DormBuildingImpl();

    public static DormBuildingImpl getInstance() {
        return instance;
    }

    @Override
    public DormBuilding selectDormBuilding(String dbno, String dbd) {
        String sql = "select * from dbuilding where dbno = ? and dbd = ?";
        return select(DormBuilding.class, sql, dbno, dbd);
    }

    @Override
    public int insertDormBuilding(String dbno, String dbd) {
        String sql = "insert into dbuilding(dbno,dbd) values(?,?)";
        return insert(sql, dbno, dbd);
    }
}
