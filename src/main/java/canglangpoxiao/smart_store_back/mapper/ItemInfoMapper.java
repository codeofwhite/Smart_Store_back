package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemInfoMapper {
    List<ItemInfo> findAllItem(@Param("uid") long uid);

}
