package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import canglangpoxiao.smart_store_back.repository.RoomRepository;
import canglangpoxiao.smart_store_back.repository.StgRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping("/add")
@RestController
public class AddLRS {
    @Autowired
    private LayoutRepository layoutRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StgRepository stgRepository;

    // 插入新的布局
    @Transactional
    @PostMapping("/insertLayout")
    @ResponseBody
    public long insertLayout(@RequestParam long uid, @RequestParam String layout_name,
                               @RequestParam long layout_size){
        String layout_img = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/LayoutDefault.png";
        layoutRepository.insertLayout(uid, layout_name, layout_size, layout_img);
        long id = layoutRepository.selectLastInsertId();
        layoutRepository.insertLayoutFamily(uid,id);
        return id;
    }

    // 插入新房间
    @Transactional
    @PostMapping("/insertRoom")
    @ResponseBody
    public long insertRoom(long uid, @RequestParam String room_name, long layout_id){
        roomRepository.insertRoom(uid, room_name, layout_id);
        long id = layoutRepository.selectLastInsertId();
        return id;
    }

    // 插入新收纳点
    @Transactional
    @PostMapping("/insertStg")
    @ResponseBody
    public long insertStg(@RequestParam long uid, @RequestParam String stg_name,
                               @RequestParam long room_id, long layout_id){
        stgRepository.insertStg(uid,stg_name,room_id,layout_id);
        long id = layoutRepository.selectLastInsertId();
        return id;
    }
}
