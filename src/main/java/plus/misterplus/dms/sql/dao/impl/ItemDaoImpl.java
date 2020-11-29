package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.ItemDao;

public class ItemDaoImpl extends BaseDao implements ItemDao {
    private static final ItemDaoImpl instance = new ItemDaoImpl();

    public static ItemDaoImpl getInstance() {
        return instance;
    }
}
