package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    // 找寻用户拥有的全部物品
    @RequestMapping(value = "/findAllItem", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemInfo> findAllItem(@RequestParam long uid){
        List<ItemInfo> List = itemRepository.findAllItem(uid);
        return List;
    }
    //用stg_id找寻物品
    @RequestMapping(value = "/useStgFindItem", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemInfo> useStgFindItem(@RequestParam long stg_id){
        List<ItemInfo> List = itemRepository.useStgFindItem(stg_id);
        return List;
    }
    // 用it_id删除物品
    @RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
    @ResponseBody
    public String deleteItem(@RequestParam long it_id){
        itemRepository.deleteItem(it_id);
        return "删除成功";
    }

}
