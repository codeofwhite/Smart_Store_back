package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.RecordReturn;
import canglangpoxiao.smart_store_back.entity.Record;
import canglangpoxiao.smart_store_back.mapper.RecordMapper;
import canglangpoxiao.smart_store_back.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepositoryImpl implements RecordRepository {
    @Autowired
    RecordMapper recordMapper;
    @Override
    public List<RecordReturn> rukuRecord(long layout_id) {
        List<RecordReturn> list = recordMapper.rukuRecord(layout_id);
        return list;
    }

    @Override
    public List<RecordReturn> chukuRecord(long layout_id) {
        List<RecordReturn> list = recordMapper.chukuRecord(layout_id);
        return list;
    }

    @Async
    @Override
    public void insertRuRecord(RecordDTO recordDTO) {
        recordMapper.insertRuRecord(recordDTO);
    }

    @Async
    @Override
    public void updateChuRecord(long uid, long it_id) {
        recordMapper.updateChuRecord(uid,it_id);
    }

    @Async
    @Override
    public void delete7DAgo() {
        recordMapper.delete7DAgo();
    }
}
