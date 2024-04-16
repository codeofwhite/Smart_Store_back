package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import canglangpoxiao.smart_store_back.repository.RoomRepository;
import canglangpoxiao.smart_store_back.repository.StgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchItemController {
    @Autowired
    LayoutRepository layoutRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StgRepository stgRepository;
    @Autowired
    ItemRepository itemRepository;

    /**
     *
     * @return 用户参与的layout_id
     */
    @PostMapping("/getLayoutId")
    @ResponseBody
    public List<LayoutInfo> getLayoutId(@RequestParam long uid){
        List<LayoutInfo> list = layoutRepository.getLayoutId(uid);
        return list;
    }

    /**
     *
     * @return 在此layout_id下的room_id
     */

    @PostMapping("/getRoomId")
    @ResponseBody
    public List<RoomInfo> getRoomId(@RequestParam long layout_id){
        List<RoomInfo> list = roomRepository.useLayoutFindRoom(layout_id);
        return list;
    }

    @PostMapping("/getStgId")
    @ResponseBody
    public List<StgInfo> getStgId(@RequestParam long room_id){
        List<StgInfo> list = stgRepository.useRoomFindStg(room_id);
        return list;
    }

    @PostMapping("/getItemId")
    @ResponseBody
    public List<ItemInfo> getItemId(@RequestParam long stg_id){
        List<ItemInfo> list = itemRepository.useStgFindItem(stg_id);
        return list;
    }

}
