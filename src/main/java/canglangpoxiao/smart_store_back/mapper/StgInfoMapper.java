package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.StgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StgInfoMapper {
    List<StgInfo> findAllStg(@Param("uid") long uid);

    List<StgInfo> useRoomFindStg(@Param("room_id") long room_id);

    List<StgInfo> findFavStg(@Param("layout_id") long layout_id);

    long getStgNum(@Param("layout_id") long layout_id);
}
