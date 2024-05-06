package canglangpoxiao.smart_store_back.controller.forEntity;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class LayoutController {
    @Autowired
    private LayoutRepository layoutRepository;

    @RequestMapping(value = "/useLayoutGetUid", method = RequestMethod.POST)
    @ResponseBody
    // 返回这个Layout下的uid
    List<Map<String, Object>> useLayoutGetUid(long layout_id){
        return layoutRepository.useLayoutGetUid(layout_id);
    }
}
