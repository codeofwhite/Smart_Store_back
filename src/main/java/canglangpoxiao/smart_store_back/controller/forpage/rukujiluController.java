package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.entity.Record;
import canglangpoxiao.smart_store_back.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class rukujiluController {

    @Autowired
    RecordRepository recordRepository;
    // 查询入库记录
    @PostMapping("/rukuRecord")
    @ResponseBody
    public List<Record> rukuRecord(long uid) {
        List<Record> list = recordRepository.rukuRecord(uid);
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
    public List<Record> chukuRecord(long uid) {
        List<Record> list = recordRepository.rukuRecord(uid);
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
}
