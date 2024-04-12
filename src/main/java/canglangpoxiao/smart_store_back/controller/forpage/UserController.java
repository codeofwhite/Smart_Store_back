package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepositoryl;
    // 扫出用户信息
    @PostMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo(@RequestParam long uid){
        List<User> list = userRepositoryl.getUserInfo(uid);
        return list;
    }
}
