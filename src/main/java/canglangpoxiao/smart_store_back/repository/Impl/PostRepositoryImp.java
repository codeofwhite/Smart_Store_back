package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.mapper.PostInfoMapper;
import canglangpoxiao.smart_store_back.repository.PostRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImp implements PostRepository {
    @Autowired
    PostInfoMapper postInfoMapper;
    @Override
    public void insertSelectedPost(long post_id){
        postInfoMapper.insertSelectedPost(post_id);
    }

    @Override
    public List<PostInfo> scrollPost() {
        List<PostInfo> list = postInfoMapper.scrollPost();
        return list;
    }
}
