package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.ItAttribute;
import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class InItemController {
    @Autowired
    private ItemRepository itemRepository;
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

    @RequestMapping(value = "/getItemAttribute", method = RequestMethod.POST)
    @ResponseBody
    public List<ItAttribute> getItemAttribute(@RequestParam List<String> itemName){
        List<ItAttribute> list = new ArrayList<>();
        List<ItAttribute> listDefault = new ArrayList<>();
        listDefault.add(itemRepository.getItemAttribute("默认物品"));
        System.out.println(itemName.size());
        for (int i =0; i<itemName.size();++i) {
            assert false;
            System.out.println(itemName.get(i));
            list.add(itemRepository.getItemAttribute(itemName.get(i)));
            if(list.get(i) == null){
                System.out.println("调用");
                list.set(i, listDefault.get(0));
            }
        }
        return list;
    }


}
