package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Guest;

import java.util.Date;
import java.util.List;

public interface GuestDao {
    public List<Guest> selectGuests();
    public List<Guest> selectGuestsWith();
    public int insertGuest(String gname, Date gdate, String dbno, String dbd, long gphone, boolean gtype);
}
