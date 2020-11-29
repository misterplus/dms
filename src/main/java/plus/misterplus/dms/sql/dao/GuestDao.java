package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Guest;

import java.util.List;

public interface GuestDao {
    public List<Guest> selectGuests();
    public List<Guest> selectGuestsWith();
}
