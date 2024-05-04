package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.ScrollPost;
import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.mapper.PostInfoMapper;
import canglangpoxiao.smart_store_back.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @Autowired
    PostInfoMapper postInfoMapper;
    @Override
    public void insertSelectedPost(long post_id){
        postInfoMapper.insertSelectedPost(post_id);
    }

    @Override
    @Cacheable(value = "postCache", key = "'post'")
    public List<ScrollPost> scrollPost() {
        List<ScrollPost> list = postInfoMapper.scrollPost();
        return list;
    }

    @Async
    @Override
    public void insertLikePost(long post_id, long uid) {
        postInfoMapper.insertLikePost(post_id,uid);
    }

    @Override
    public List<PostInfo> getUserShared(long uid) {
        return postInfoMapper.getUserShared(uid);
    }

    @Override
    public List<PostInfo> getUserLiked(long uid) {
        return postInfoMapper.getUserLiked(uid);
    }

    @Override
    @CacheEvict(value = "postCache", key = "'post'")
    public void addNewPost(String post_media, String post_name, String post_detail, long uid) {
        postInfoMapper.addNewPost( post_media,  post_name,  post_detail,  uid);
    }

    @Override
    public long selectLastPostInsertId() {
        return postInfoMapper.selectLastPostInsertId();
    }

    @Async
    @Override
    public void addPostLike(long post_id) {
        postInfoMapper.addPostLike(post_id);
    }

    @Async
    @Override
    public void insertShared(long uid, long post_id) {
        postInfoMapper.insertShared(uid ,post_id);
    }

    @Override
    public List<PostInfo> getPostDetail(long post_id) {
        return postInfoMapper.getPostDetail(post_id);
    }

    @Override
    @CacheEvict(value = "postCache", key = "'post'")
    public void deletePost(long post_id) {
        postInfoMapper.deletePost(post_id);
    }

    @Async
    @Override
    public void deleteLikedPost(long post_id, long uid) {
        postInfoMapper.deleteLikedPost(post_id, uid);
    }

    @Override
    public long whetherLikeOrNot(long post_id, long uid) {
        return postInfoMapper.whetherLikeOrNot(post_id,uid);
    }
}
