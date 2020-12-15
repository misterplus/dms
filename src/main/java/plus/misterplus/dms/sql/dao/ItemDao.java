package plus.misterplus.dms.sql.dao;

import plus.misterplus.dms.sql.entity.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> selectItems();
}
