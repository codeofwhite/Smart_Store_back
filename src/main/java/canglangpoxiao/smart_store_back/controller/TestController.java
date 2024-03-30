package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserRepository userRepository;
    //    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/getUsers",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(){
        List<User> userList = userRepository.findAll();
        return  userList;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public boolean register(@RequestParam("userId") String userId,
                            @RequestParam("userName") String userName,
                            @RequestParam("password") String password){
        try {
            userRepository.register(userId,userName,password);
            System.out.println("可以正常执行");
            return true; //注册成功则返回true
        } catch (Exception e) {
            e.printStackTrace();
        }return false;
    }



        @PostMapping("/login")
        public  ResponseEntity<String>  login(@RequestBody LoginDTO loginDTO) {
            String uid = loginDTO.getUserId();
            String upwd = loginDTO.getPassword();
            User user=null;
            System.out.println(uid);
            System.out.println(upwd);
            user = userRepository.login(uid,upwd);
            if(user == null)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failure");
            if(user.getPassword().equals(upwd)){
                return ResponseEntity.ok("success");}
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failure");
        }

}


