package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Admin;

import java.util.List;

public interface AdminDao {
    public Admin selectAdmin(String adno);
    public List<Admin> selectAdmins();
    public int insertAdmin(String adno, String adpass, String adname);
}
