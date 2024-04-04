package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.repository.RoomRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @RequestMapping(value = "/findAllRoom", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomInfo> findAllRoom(@RequestParam long uid){
        List<RoomInfo> list = repository.findAllRoom(uid);
        return list;
    }
}
