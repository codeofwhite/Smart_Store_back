package canglangpoxiao.smart_store_back.controller.forEntity;

import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.repository.StgRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StgController {
    @Autowired
    private StgRepository stgRepository;

    // 找到该用户拥有的全部stg
    @RequestMapping(value = "/findAllStg", method = RequestMethod.POST)
    @ResponseBody
    public List<StgInfo> findAllStg(@RequestParam long uid){
        List<StgInfo> list = stgRepository.findAllStg(uid);
        return list;
    }

    // 使用room_id找到对应的stg
    @RequestMapping(value = "/useRoomFindStg", method = RequestMethod.POST)
    @ResponseBody
    public List<StgInfo> useRoomFindStg(@RequestParam long room_id){
        List<StgInfo> list = stgRepository.useRoomFindStg(room_id);
        return list;
    }
}