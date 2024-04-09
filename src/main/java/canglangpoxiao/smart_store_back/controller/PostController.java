package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    // 用户发一篇新的post
    @RequestMapping(value = "/insertSelectedPost", method = RequestMethod.POST)
    @ResponseBody
    String insertSelectedPost(@RequestParam long post_id){
        postRepository.insertSelectedPost(post_id);
        return  "插入成功";
    }
}
