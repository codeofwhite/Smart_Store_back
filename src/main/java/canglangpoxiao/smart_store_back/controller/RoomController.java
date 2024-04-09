package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    // 找到该用户拥有的全部room
    @RequestMapping(value = "/findAllRoom", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomInfo> findAllRoom(@RequestParam long uid){
        List<RoomInfo> list = roomRepository.findAllRoom(uid);
        return list;
    }

    /*
    * SELECT room_id FROM room_info WHERE layout_id = #{layout_id};
    * */
    @RequestMapping(value = "/useLayoutFindRoom", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomInfo> useLayoutFindRoom(@RequestParam long layout_id){
        List<RoomInfo> list = roomRepository.useLayoutFindRoom(layout_id);
        return  list;
    }
}
