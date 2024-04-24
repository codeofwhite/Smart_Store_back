package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class InviteFamily {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/inviteFamily")
    @ResponseBody
    String inviteFamily(@Param("uid") long uid){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder inviteCode = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(characters.length());
            inviteCode.append(characters.charAt(index));
        }

        userRepository.inviteFamily(uid,inviteCode.toString());

        return "fuck";
    }

    @PostMapping("/acceptInvite")
    @ResponseBody
    String acceptInvite(@Param("invite_code") String invite_code){
        String uid_copy = userRepository.acceptInvite(invite_code);
        if(uid_copy == null){
            return "fail";
        }
        else{
            return uid_copy;
        }
    }
}
