package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.DormRoomDao;
import plus.misterplus.dms.sql.entity.DormRoom;

import java.util.List;

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

    @Override
    public List<DormRoom> selectDRooms() {
        String sql = "select * from droom";
        return selectMultiple(DormRoom.class, sql);
    }

    @Override
    public int insertDormRoom(String dbno, String dbd, String drbno, int dcap) {
        String sql = "insert into droom(dbno,dbd,drbno) values(?,?,?)";
        return insert(sql, dbno, dbd, drbno);
    }

    @Override
    public int updateDormMonitor(String dbno, String dbd, String drbno, String dmno) {
        String sql = "update droom set dmno = ? where dbno = ? and dbd = ? and drbno = ?";
        return update(sql, dmno, dbno, dbd, drbno);
    }

    @Override
    public List<DormRoom> selectDRoomNotFull() {
        String sql = "exec selectDRoomNotFull";
        return procedure(DormRoom.class, sql);
    }
}