package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.entity.com.UserPost;
import canglangpoxiao.smart_store_back.repository.PostRepository;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class stqzhuyeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @PostMapping("/getPUserInfo")
    @ResponseBody
    List<UserPost> getPUserInfo(@Param("uid") long uid){
         List<UserPost> list =  userRepository.getPUserInfo(uid);
         return list;
    }
    @PostMapping("/getUserShared")
    @ResponseBody
    List<PostInfo> getUserShared(@Param("uid") long uid){
        List<PostInfo> list =  postRepository.getUserShared(uid);
        return list;
    }
    @PostMapping("/getUserLiked")
    @ResponseBody
    List<PostInfo> getUserLiked(@Param("uid") long uid){
        List<PostInfo> list =  postRepository.getUserLiked(uid);
        return list;
    }

}
