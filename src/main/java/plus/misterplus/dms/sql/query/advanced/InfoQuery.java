package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.impl.DormRoomDaoImpl;
import plus.misterplus.dms.sql.entity.DormRoom;

public class InfoQuery {
    public static DormRoom selectDormRoom(String dbno, String dbd, String drbno) {
        return DormRoomDaoImpl.getInstance().selectDormRoom(dbno, dbd, drbno);
    }
}
