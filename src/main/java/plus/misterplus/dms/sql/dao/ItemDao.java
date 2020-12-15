package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Item;

import java.util.Date;
import java.util.List;

public interface ItemDao {
    public List<Item> selectItems();
    public int insertItem(String iname, Date itime, String sno, String dbno, String dbd, boolean itype);
}
