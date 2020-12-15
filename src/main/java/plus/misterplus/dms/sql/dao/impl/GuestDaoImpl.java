package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.GuestDao;
import plus.misterplus.dms.sql.entity.Guest;
import plus.misterplus.dms.sql.entity.Item;

import java.util.Date;
import java.util.List;

public class GuestDaoImpl extends BaseDao implements GuestDao {
    private static final GuestDaoImpl instance = new GuestDaoImpl();

    public static GuestDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Guest> selectGuests() {
        String sql = "select * from guest order by gdate desc";
        return selectMultiple(Guest.class, sql);
    }

    @Override
    public List<Guest> selectGuestsWith() {
        return null;
    }

    @Override
    public int insertGuest(String gname, Date gdate, String dbno, String dbd, long gphone, boolean gtype) {
        String sql = "insert into guest(gname, gdate, dbno, dbd, gphone, gtype) values(?,?,?,?,?,?)";
        return insert(sql, gname, gdate, dbno, dbd, gphone, gtype);
    }
}
