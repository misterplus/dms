package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.DormRoom;

public interface DormRoomDao {
    public DormRoom selectDormRoom(String dbno, String dbd, String drbno);
}
