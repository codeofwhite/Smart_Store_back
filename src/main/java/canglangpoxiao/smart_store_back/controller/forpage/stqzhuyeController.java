package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.com.UserPost;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class stqzhuyeController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/getPUserInfo")
    @ResponseBody
    List<UserPost> getPUserInfo(@Param("uid") long uid){
         List<UserPost> list =  userRepository.getPUserInfo(uid);
         return list;
    }
}
