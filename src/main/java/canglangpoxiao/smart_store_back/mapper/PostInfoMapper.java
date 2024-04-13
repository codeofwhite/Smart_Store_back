package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostInfoMapper {
    public void insertSelectedPost(@Param("post_id") long post_id);

    public List<PostInfo> scrollPost();
}
