package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

@Mapper
public interface ItemInfoMapper {
    List<ItemInfo> findAllItem(@Param("uid") long uid);

    List<ItemInfo> useStgFindItem(@Param("stg_id") long stg_id);

    void deleteItem(@Param("it_id") long it_id);

}
