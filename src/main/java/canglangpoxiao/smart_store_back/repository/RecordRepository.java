package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.entity.Record;

import java.util.List;

public interface RecordRepository {
    List<Record> rukuRecord(long uid);

    List<Record> chukuRecord(long uid);

    // 插入入库记录
    void insertRuRecord(RecordDTO recordDTO);

    // 更新出库记录
    void updateChuRecord(long uid, long it_id);
}
