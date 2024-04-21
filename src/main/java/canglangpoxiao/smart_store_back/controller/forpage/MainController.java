package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import canglangpoxiao.smart_store_back.repository.StgRepository;
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
    @Autowired
    StgRepository stgRepository;


    // 这个layout下的家庭人数（算上自己）
    // 完成
    @RequestMapping(value = "/getFamNum", method = RequestMethod.POST)
    @ResponseBody
    public long getFamNum(long layout_id){
        return layoutRepository.getFamNum(layout_id);
    }

    // 带期限物品的时间
    // 完成
    @RequestMapping(value = "/getBestBefore", method = RequestMethod.POST)
    @ResponseBody
    public Date getBestBefore(long item_id) {
        return itemRepository.getBestBefore(item_id);
    }

    // 在这个layout下的stg总数
    @RequestMapping(value = "/getStgNum", method = RequestMethod.POST)
    @ResponseBody
    long getStgNum(@Param("layout_id") long layout_id){
        return stgRepository.getStgNum(layout_id);
    }

    // 在这个layout下的物品总数
    @RequestMapping(value = "/getItemNum", method = RequestMethod.POST)
    @ResponseBody
    long getItemNum(@Param("layout_id") long layout_id){
        return itemRepository.getItemNum(layout_id);
    }

    // 扫出用户参与的layout
    // 完成
    @RequestMapping(value = "/getLayoutId", method = RequestMethod.POST)
    @ResponseBody
    List<LayoutInfo> getLayoutId(@Param("uid") long uid){
        List<LayoutInfo> list = layoutRepository.getLayoutId(uid);
        return list;
    }

    // 星标物品
    // 如果要那种效果要存储过程
    @RequestMapping(value = "/findFavItem", method = RequestMethod.POST)
    @ResponseBody
    List<ItemInfo> findFavItem(@Param("layout_id") long layout_id){
        List<ItemInfo> list = itemRepository.findFavItem(layout_id);
        return list;
    }


    // 星标空间stg
    // 做法一——存储过程，一层一层扫
    // 做法二——直接存进去一个layout_id
    @RequestMapping(value = "/findFavStg", method = RequestMethod.POST)
    @ResponseBody
    List<StgInfo> findFavStg(@Param("layout_id") long layout_id){
        List<StgInfo> list = stgRepository.findFavStg(layout_id);
        return list;
    }

}
