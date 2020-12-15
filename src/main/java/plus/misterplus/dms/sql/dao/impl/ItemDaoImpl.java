package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.ItemDao;
import plus.misterplus.dms.sql.entity.Item;

import java.util.Date;
import java.util.List;

public class ItemDaoImpl extends BaseDao implements ItemDao {
    private static final ItemDaoImpl instance = new ItemDaoImpl();

    public static ItemDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Item> selectItems() {
        String sql = "select * from items order by itime desc";
        return selectMultiple(Item.class, sql);
    }

    @Override
    public int insertItem(String iname, Date itime, String sno, String dbno, String dbd, boolean itype) {
        String sql = "insert into items(iname, itime, sno, dbno, dbd, itype) values(?,?,?,?,?,?)";
        return insert(sql, iname, itime, sno, dbno, dbd, itype);
    }
}
