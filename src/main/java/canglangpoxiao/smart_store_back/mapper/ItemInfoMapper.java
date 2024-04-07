package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

@Mapper
public interface ItemInfoMapper {
    List<ItemInfo> findAllItem(@Param("uid") long uid);

    List<ItemInfo> useStgFindItem(@Param("stg_id") long stg_id, @Param("uid") long uid);

    void deleteItem(@Param("it_id") long it_id, @Param("uid") long uid);

    void insertItem(@Param("it_name") String it_name,
                    @Param("it_size") long it_size, @Param("it_type") String it_type ,
                    @Param("best_before") java.sql.Date best_before,@Param("date_in_produced") java.sql.Date date_in_produced,
                    @Param("it_img") String it_img, @Param("stg_id") long stg_id, @Param("uid") long uid);
}
