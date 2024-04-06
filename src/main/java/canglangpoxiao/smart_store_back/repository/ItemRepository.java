package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.ItemInfo;

import java.util.List;

public interface ItemRepository {
    public List<ItemInfo> findAllItem(long uid);

    public List<ItemInfo> useStgFindItem(long stg_id);

    public void deleteItem(long it_id);

}