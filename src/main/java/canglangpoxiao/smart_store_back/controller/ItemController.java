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

    @RequestMapping(value = "/findAllItem", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemInfo> findAllItem(@RequestParam long uid){
        System.out.println(uid);
        List<ItemInfo> itemInfoListList = itemRepository.findAllItem(uid);
        return itemInfoListList;
    }

}
