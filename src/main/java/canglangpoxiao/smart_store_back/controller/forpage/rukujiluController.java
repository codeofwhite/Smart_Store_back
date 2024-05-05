package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.RecordReturn;
import canglangpoxiao.smart_store_back.entity.Record;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import canglangpoxiao.smart_store_back.repository.RecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class rukujiluController {

    @Autowired
    RecordRepository recordRepository;
    @Autowired
    ItemRepository itemRepository;

    // 查询入库记录
    @PostMapping("/rukuRecord")
    @ResponseBody
    public List<RecordReturn> rukuRecord(long layout_id) {
        System.out.println(layout_id);
        List<RecordReturn> list = recordRepository.rukuRecord(layout_id);
        return list;
    }

    // 插入入库记录
    @PostMapping("/insertRuRecord")
    public String insertRuRecord(@RequestBody RecordDTO recordDTO){
        recordRepository.insertRuRecord(recordDTO);
        return "入库成功";
    }

    // 查询出库记录
    @PostMapping("/chukuRecord")
    @ResponseBody
    public List<RecordReturn> chukuRecord(long layout_id) {
        System.out.println(layout_id);
        List<RecordReturn> list = recordRepository.chukuRecord(layout_id);
        return list;
    }

    // 更新出库记录
    // 还要改
    @PostMapping("/updateChuRecord")
    @ResponseBody
    public String updateChuRecord(@RequestParam long uid, @RequestParam long it_id){
        System.out.println(uid);
        System.out.println(it_id);
        recordRepository.updateChuRecord(uid,it_id);
        return "出库成功";
    }

    // 出库
    @PostMapping("/ChuItem")
    @ResponseBody
    @Transactional // 事务管理
    public String ChuItem(@RequestParam long it_id, @RequestParam long uid)
    {
        System.out.println(it_id);
        itemRepository.ChuItem(it_id);
        recordRepository.updateChuRecord(uid,it_id);
        return "出库成功";
    }

    // 删除七天前的任务
    @GetMapping("/delete7DAgo")
    @ResponseBody
    public String delete7DAgo()
    {
        recordRepository.delete7DAgo();
        return "删除成功";
    }
}
