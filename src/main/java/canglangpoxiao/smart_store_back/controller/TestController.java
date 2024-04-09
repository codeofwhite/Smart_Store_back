package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.LoginDTO;
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

    // 找到全部用户
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    // 注册
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginDTO loginDTO) {  //复用，功能相同
        String u_tel = loginDTO.getUserTel();
        String upwd = loginDTO.getPassword();
        User user = null;
        user = userRepository.login(u_tel, upwd);  //判断用户是否存在
        if (user == null) {  //空用户，可以注册
            userRepository.register(u_tel, upwd);
            return ResponseEntity.ok("sign_up_success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("repeat_sign_up");
        }
    }

    // 登录
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String u_tel = loginDTO.getUserTel();
        String upwd = loginDTO.getPassword();
        User user = null;
        System.out.println(u_tel);
        System.out.println(upwd);
        user = userRepository.login(u_tel, upwd);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NULL");
        }
        if (user.getUpwd().equals(upwd)) {
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failure");
    }
}


