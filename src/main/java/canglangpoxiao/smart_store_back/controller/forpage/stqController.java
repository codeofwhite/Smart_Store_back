package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.ScrollPost;
import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class stqController {
    @Autowired
    PostRepository postRepository;

    // 返回30条帖子简介
    @GetMapping("/scrollPost")
    public List<ScrollPost> scrollPost(){
        List<ScrollPost> list =postRepository.scrollPost();
        return list;
    }
}
