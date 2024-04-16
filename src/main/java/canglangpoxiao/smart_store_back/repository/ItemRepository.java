package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ItemRepository {
    public List<ItemInfo> findAllItem(long uid);

    public List<ItemInfo> useStgFindItem(long stg_id);

    public void deleteItem(long it_id, long uid);

    public void insertItem(ItemInfo itemInfo);

    Date getBestBefore(long item_id);
}
