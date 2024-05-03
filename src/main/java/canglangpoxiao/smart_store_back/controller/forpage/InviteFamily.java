package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
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
    @Autowired
    LayoutRepository layoutRepository;

    @PostMapping("/inviteFamily")
    @ResponseBody
    String inviteFamily(@Param("uid") long uid, long layout_id){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder inviteCode = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(characters.length());
            inviteCode.append(characters.charAt(index));
        }

        userRepository.inviteFamily(uid,inviteCode.toString(),layout_id);

        return inviteCode.toString();
    }

    @PostMapping("/acceptInvite")
    @ResponseBody
    Long acceptInvite(@Param("invite_code") String invite_code, long uid){
        Long layout_id = userRepository.acceptInvite(invite_code);
        System.out.println(layout_id);
        if(layout_id == null){
            return null;
        }
        else{
            layoutRepository.insertLayoutFamily(uid,layout_id);
            return layout_id;
        }
    }
}
