package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
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

    void deletePost(long post_id);

    // 移除收藏的/喜欢的帖子
    void deleteLikedPost(long post_id, long uid);

    // 判断用户是否对该帖子点赞。
    long whetherLikeOrNot(long post_id, long uid);
}
