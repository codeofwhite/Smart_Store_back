package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface PostInfoMapper {
    public void insertSelectedPost(@Param("post_id") long post_id);

    public List<PostInfo> scrollPost();

    void insertLikePost(long post_id, long uid);


    List<PostInfo> getUserShared(@Param("uid") long uid);

    List<PostInfo> getUserLiked(@Param("uid") long uid);

    // 发布新帖子
    void addNewPost(String post_media, String post_name, String post_detail, long uid);

    long selectLastPostInsertId();

    void addPostLike(long post_id);

    void insertShared(long uid, long post_id);

    public List<PostInfo> getPostDetail(long post_id);
}
