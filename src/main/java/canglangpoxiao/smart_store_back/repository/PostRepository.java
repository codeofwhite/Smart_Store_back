package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostRepository {
    public void insertSelectedPost(long post_id);

    public List<PostInfo> scrollPost();

    void insertLikePost(long post_id, long uid);


    List<PostInfo> getUserShared(long uid);

    List<PostInfo> getUserLiked(long uid);

    void addNewPost(String post_media, String post_name, String post_detail, long uid);

    long selectLastPostInsertId();

    // 增加帖子的点赞数
    void addPostLike(long post_id);

    void insertShared(long uid, long post_id);

    public List<PostInfo> getPostDetail(long post_id);

    void deletePost(long post_id);

    // 移除收藏的/喜欢的帖子
    void deleteLikedPost(long post_id, long uid);

    // 判断用户是否对该帖子点赞
    long whetherLikeOrNot(long post_id, long uid);
}
