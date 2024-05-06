package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.ItAttribute;
import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ItemRepository {
    public List<ItemInfo> findAllItem(long uid);

    public List<ItemInfo> useStgFindItem(long stg_id);

    public void deleteItem(long it_id, long uid);

    public long insertItem(ItemInfo itemInfo);

    // 拿出过期日期
    Date getBestBefore(long item_id);

    List<ItemInfo> findFavItem(long layout_id);

    long getItemNum(@Param("layout_id") long layout_id);

    // 查询物品属性成分
    ItAttribute getItemAttribute(String itemName);

    long ChuItem(long it_id);

    void updateItemImg(String it_img, long it_id);

    long selectLastItemInsertId();

    // 用it_id找到对应的stg_id
    long useItIdFindStgId(long it_id);
}
