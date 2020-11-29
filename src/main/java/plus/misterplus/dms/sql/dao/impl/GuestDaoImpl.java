package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.GuestDao;
import plus.misterplus.dms.sql.entity.Guest;

import java.util.List;

public class GuestDaoImpl extends BaseDao implements GuestDao {
    private static final GuestDaoImpl instance = new GuestDaoImpl();

    public static GuestDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Guest> selectGuests() {
        return null;
    }

    @Override
    public List<Guest> selectGuestsWith() {
        return null;
    }
}
