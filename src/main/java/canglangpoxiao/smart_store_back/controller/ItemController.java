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
    // 插入物品
    @RequestMapping(value = "/insertItem", method = RequestMethod.POST)
    @ResponseBody
    public String insertItem(String it_name, long it_size, String it_type ,
                             String best_before, String date_in_produced,
                             String it_img, long stg_id, long uid){


        Date best_before_t, date_in_produced_t;

        if (Objects.equals(best_before, "")){
            best_before_t = Date.valueOf("1000-01-01");
        }
        else {
            best_before_t = Date.valueOf(best_before);
        }
        if (Objects.equals(date_in_produced, "")){
            date_in_produced_t = Date.valueOf("1000-01-01");
        }
        else{
            date_in_produced_t = Date.valueOf(date_in_produced);
        }
        if(it_type.isEmpty()){
            it_type = "生活杂物";
        }
        if(it_img.isEmpty()){
            it_img = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/ItemDefault.png";
        }

        itemRepository.insertItem(it_name,it_size,it_type,best_before_t,date_in_produced_t,it_img,stg_id,uid);
        return "插入成功";
    }
}
