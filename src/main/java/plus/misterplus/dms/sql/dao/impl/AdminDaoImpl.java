package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.AdminDao;
import plus.misterplus.dms.sql.entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao {

    private static final AdminDaoImpl instance = new AdminDaoImpl();

    public static AdminDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Admin selectAdmin(String adno) {
        String sql = "select * from admin where adno = ?";
        return select(Admin.class, sql, adno);
    }
}
