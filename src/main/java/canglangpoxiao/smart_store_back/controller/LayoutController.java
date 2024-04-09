package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class LayoutController {
    @Autowired
    private LayoutRepository layoutRepository;
    //    private JdbcTemplate jdbcTemplate;

    // 使用uid找到该用户拥有的布局
    @PostMapping("/findAllLayout")
    @ResponseBody
    public List<LayoutInfo> findAllLayout(@RequestParam long uid){
        List<LayoutInfo> list = layoutRepository.findAllLayout(uid);
        return  list;
    }

    // 插入新的布局
    @PostMapping("/insertLayout")
    @ResponseBody
    public String insertLayout(@RequestParam long uid,  @RequestParam String layout_name,
                               @RequestParam long layout_size, String layout_img){
        if(Objects.equals(layout_img, "")){
            layout_img = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/LayoutDefault.png";
        }
        layoutRepository.insertLayout(uid, layout_name, layout_size, layout_img);
        return "插入成功";
    }
}
