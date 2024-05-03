package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;
    // 用户发布一篇新的post
    @RequestMapping(value = "/addNewPost", method = RequestMethod.POST)
    @ResponseBody
    long addNewPost(String post_media, String post_name, String post_detail, long uid){
        postRepository.addNewPost( post_media,  post_name,  post_detail,  uid);
        long post_id  = postRepository.selectLastPostInsertId();
        postRepository.insertShared(uid, post_id);
        return  post_id;
    }

    // 用户喜欢一个post，加入user_like
    @Transactional
    @RequestMapping(value = "/insertLikePost", method = RequestMethod.POST)
    @ResponseBody
    String insertLikePost(@RequestParam long post_id, @RequestParam long uid){
        postRepository.addPostLike(post_id);
        postRepository.insertLikePost(post_id,uid);
        return  "插入成功";
    }

    // 用户发一篇新的post加入精选
    @RequestMapping(value = "/addSelectedPost", method = RequestMethod.POST)
    @ResponseBody
    String insertSelectedPost(@RequestParam long post_id){
        postRepository.insertSelectedPost(post_id);
        return  "插入成功";
    }

    // 获取帖子的详细信息
    @PostMapping("/getPostDetail")
    public List<PostInfo> getPostDetail(@RequestParam long post_id){
        List<PostInfo> list =postRepository.getPostDetail(post_id);
        return list;
    }
    // 删除帖子
    @PostMapping("/deletePost")
    String deletePost(long post_id){
        postRepository.deletePost(post_id);
        return "删除成功";
    }

    // 移除收藏的/喜欢的帖子
    @PostMapping("/deleteLikedPost")
    String deleteLikedPost(long post_id, long uid){
        postRepository.deleteLikedPost(post_id, uid);
        return "删除成功";
    }

    // 判断用户是否对该帖子点赞。
    @PostMapping("/whetherLikeOrNot")
    long whetherLikeOrNot(long post_id, long uid){
        long count = postRepository.whetherLikeOrNot(post_id, uid);
        if(count > 1){
            count = 1;
        }
        return count;
    }


}
