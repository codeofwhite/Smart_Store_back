package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomInfoMapper {
    List<RoomInfo> findAllRoom(@Param("uid") long uid);
}
