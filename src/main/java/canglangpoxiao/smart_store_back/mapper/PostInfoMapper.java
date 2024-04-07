package canglangpoxiao.smart_store_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostInfoMapper {
    public void insertSelectedPost(@Param("post_id") long post_id);
}
