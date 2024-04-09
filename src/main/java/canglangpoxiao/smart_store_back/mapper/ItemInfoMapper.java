package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
public interface ItemInfoMapper {
    List<ItemInfo> findAllItem(@Param("uid") long uid);

    List<ItemInfo> useStgFindItem(@Param("stg_id") long stg_id, @Param("uid") long uid);

    void deleteItem(@Param("it_id") long it_id, @Param("uid") long uid);

    void insertItem(@RequestBody ItemInfo itemInfo);
}
