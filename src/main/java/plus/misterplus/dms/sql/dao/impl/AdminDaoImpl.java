package plus.misterplus.dms.sql.dao.impl;

import plus.misterplus.dms.sql.dao.AdminDao;
import plus.misterplus.dms.sql.entity.Admin;

import java.util.List;

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

    @Override
    public List<Admin> selectAdmins() {
        String sql = "select * from admin";
        return selectMultiple(Admin.class, sql);
    }

    @Override
    public int insertAdmin(String adno, String adpass, String adname) {
        String sql = "insert into admin(adno,adpass,adname) values(?,?,?)";
        return insert(sql, adno, adpass, adname);
    }
}
