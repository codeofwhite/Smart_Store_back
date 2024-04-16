package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {
    @Autowired
    LayoutRepository layoutRepository;
    @Autowired
    ItemRepository itemRepository;


    // 这个layout下的家庭人数（算上自己）
    // 完成
    @RequestMapping(value = "/getFamNum", method = RequestMethod.POST)
    @ResponseBody
    public long getFamNum(long layout_id){
        return layoutRepository.getFamNum(layout_id);
    }

    // 带期限物品的时间
    @RequestMapping(value = "/getBestBefore", method = RequestMethod.POST)
    @ResponseBody
    public Date getBestBefore(long item_id) {
        return itemRepository.getBestBefore(item_id);
    }

    // 在这个layout下的stg总数
    @RequestMapping(value = "/getStgNum", method = RequestMethod.POST)
    @ResponseBody
    long getStgNum(){
        return 0;
    }

    // 在这个layout下的物品总数
    @RequestMapping(value = "/insertItem", method = RequestMethod.POST)
    @ResponseBody
    long getItemNum(){
        return 0;
    }

    // 扫出用户参与的layout
    @RequestMapping(value = "/getLayoutId", method = RequestMethod.POST)
    @ResponseBody
    List<LayoutInfo> getLayoutId(@Param("uid") long uid){
        List<LayoutInfo> list = layoutRepository.getLayoutId(uid);
        return list;
    }

    // 星标物品
    // 如果要那种效果要存储过程


    // 星标空间stg
    // 存储过程

}
