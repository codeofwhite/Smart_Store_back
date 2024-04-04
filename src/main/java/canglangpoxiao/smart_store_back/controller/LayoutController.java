package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LayoutController {
    @Autowired
    private LayoutRepository layoutRepository;
    //    private JdbcTemplate jdbcTemplate;

    @PostMapping("/findAllLayout")
    @ResponseBody
    public List<LayoutInfo> findAllLayout(@RequestParam long uid){
        List<LayoutInfo> list = layoutRepository.findAllLayout(uid);
        return  list;
    }
}
