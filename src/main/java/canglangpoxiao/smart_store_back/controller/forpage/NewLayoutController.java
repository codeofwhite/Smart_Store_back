package canglangpoxiao.smart_store_back.controller.forpage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewLayoutController {
    @PostMapping("/insertNewLayout")
    @ResponseBody
    // 插入新布局
    String insertNewLayout(){
        return "插入成功";
    }
    @PostMapping("/insertNewRoom")
    @ResponseBody
    // 插入新房间
    String insertNewRoom(){
        return "插入成功";
    }

    // 插入新收纳点
    @PostMapping("/insertNewStg")
    @ResponseBody
    String insertNewStg(){
        return "插入成功";
    }
}
