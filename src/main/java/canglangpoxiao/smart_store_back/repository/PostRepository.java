package canglangpoxiao.smart_store_back.repository;

import org.apache.ibatis.annotations.Param;

public interface PostRepository {
    public void insertSelectedPost(@Param("post_id") long post_id);
}
