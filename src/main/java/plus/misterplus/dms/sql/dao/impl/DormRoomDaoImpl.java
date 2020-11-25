package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.DormRoomDao;
import plus.misterplus.dms.sql.entity.DormRoom;

public class DormRoomDaoImpl extends BaseDao implements DormRoomDao {

    private static final DormRoomDaoImpl instance = new DormRoomDaoImpl();

    public static DormRoomDaoImpl getInstance() {
        return instance;
    }

    @Override
    public DormRoom selectDormRoom(String dbno, String dbd, String drbno) {
        String sql = "select * from droom where dbno = ? and dbd = ? and drbno = ?";
        return select(DormRoom.class, sql, dbno, dbd, drbno);
    }
}