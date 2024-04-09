package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    // 找寻某个用户拥有的全部物品
    @RequestMapping(value = "/findAllItem", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemInfo> findAllItem(@RequestParam long uid){
        List<ItemInfo> List = itemRepository.findAllItem(uid);
        return List;
    }
    //用stg_id找寻物品
    @RequestMapping(value = "/useStgFindItem", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemInfo> useStgFindItem(@RequestParam long stg_id, @RequestParam long uid){
        List<ItemInfo> List = itemRepository.useStgFindItem(stg_id, uid);
        return List;
    }
    // 用it_id删除物品
    @RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
    @ResponseBody
    public String deleteItem(@RequestParam long it_id, @RequestParam long uid){
        itemRepository.deleteItem(it_id, uid);
        return "删除成功";
    }
    // 插入新物品，日期可以传过NULL，要传的话必须满足格式如——1000-01-01
    @RequestMapping(value = "/insertItem", method = RequestMethod.POST)
    @ResponseBody
    public String insertItem(@RequestBody ItemInfo itemInfo){

        if (Objects.equals(itemInfo.getBest_before(), null)){
            itemInfo.setBest_before(Date.valueOf("1000-01-01"));
        }
        if(itemInfo.getIt_type() == null){
            itemInfo.setIt_type("生活杂物");
        }
        if(itemInfo.getIt_img().isEmpty()){
            itemInfo.setIt_img("https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/ItemDefault.png");
        }

        itemRepository.insertItem(itemInfo);
        return "插入成功";
    }
}
