package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.DormRoom;

import java.util.List;

public interface DormRoomDao {
    public DormRoom selectDormRoom(String dbno, String dbd, String drbno);
    public List<DormRoom> selectDRooms();
    public int insertDormRoom(String dbno, String dbd, String drbno);
}
