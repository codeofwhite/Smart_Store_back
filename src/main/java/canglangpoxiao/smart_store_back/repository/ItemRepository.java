package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemRepository {
    public List<ItemInfo> findAllItem(long uid);

    public List<ItemInfo> useStgFindItem(long stg_id, long uid);

    public void deleteItem(long it_id, long uid);

    public void insertItem(String it_name, long it_size, String it_type ,
                           java.sql.Date best_before, java.sql.Date date_in_produced,
                           String it_img, long stg_id, long uid);

}
