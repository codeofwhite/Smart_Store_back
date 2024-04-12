package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.entity.Record;
import canglangpoxiao.smart_store_back.mapper.RecordMapper;
import canglangpoxiao.smart_store_back.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepositoryImpl implements RecordRepository {
    @Autowired
    RecordMapper recordMapper;
    @Override
    public List<Record> rukuRecord(long uid) {
        List<Record> list = recordMapper.rukuRecord(uid);
        return list;
    }

    @Override
    public List<Record> chukuRecord(long uid) {
        List<Record> list = recordMapper.chukuRecord(uid);
        return list;
    }

    @Override
    public void insertRuRecord(RecordDTO recordDTO) {
        recordMapper.insertRuRecord(recordDTO);
    }

    @Override
    public void updateChuRecord(long uid, long it_id) {
        recordMapper.updateChuRecord(uid,it_id);
    }
}
