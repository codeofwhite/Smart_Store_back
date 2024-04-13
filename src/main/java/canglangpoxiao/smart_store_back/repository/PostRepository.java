package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostRepository {
    public void insertSelectedPost(long post_id);

    public List<PostInfo> scrollPost();
}
