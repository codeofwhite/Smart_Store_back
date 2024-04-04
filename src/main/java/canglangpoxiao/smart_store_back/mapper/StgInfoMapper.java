package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.StgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StgInfoMapper {
    List<StgInfo> findAllStg(@Param("uid") long uid);
}
