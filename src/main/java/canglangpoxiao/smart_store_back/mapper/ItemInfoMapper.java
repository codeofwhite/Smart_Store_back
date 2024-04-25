package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.ItAttribute;
import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Mapper
public interface ItemInfoMapper {
    List<ItemInfo> findAllItem(@Param("uid") long uid);

    List<ItemInfo> useStgFindItem(@Param("stg_id") long stg_id);

    void deleteItem(@Param("it_id") long it_id, @Param("uid") long uid);

    void insertItem(@RequestBody ItemInfo itemInfo);

    Date getBestBefore(long item_id);

    List<ItemInfo> findFavItem(@Param("layout_id") long layout_id);

    long getItemNum(@Param("layout_id") long layout_id);
    // 返回物品属性
    ItAttribute getItemAttribute(String itemName);

    void ChuItem(long it_id);

    void updateItemImg(String it_img, long it_id);

}
