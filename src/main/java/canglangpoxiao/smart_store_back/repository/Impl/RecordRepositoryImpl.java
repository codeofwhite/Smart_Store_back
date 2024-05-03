package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.RecordReturn;
import canglangpoxiao.smart_store_back.mapper.RecordMapper;
import canglangpoxiao.smart_store_back.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepositoryImpl implements RecordRepository {
    @Autowired
    RecordMapper recordMapper;
    @Override
    @Cacheable("inRecordCache")
    public List<RecordReturn> rukuRecord(long layout_id) {
        List<RecordReturn> list = recordMapper.rukuRecord(layout_id);
        return list;
    }

    @Override
    @Cacheable("outRecordCache")
    public List<RecordReturn> chukuRecord(long layout_id) {
        List<RecordReturn> list = recordMapper.chukuRecord(layout_id);
        return list;
    }

    @Async
    @Override
    @CachePut("inRecordCache")
    public void insertRuRecord(RecordDTO recordDTO) {
        recordMapper.insertRuRecord(recordDTO);
    }

    @Async
    @Override
    @CacheEvict("outRecordCache")
    public void updateChuRecord(long uid, long it_id) {
        recordMapper.updateChuRecord(uid,it_id);
    }

    @Async
    @Override
    @CacheEvict({"inRecordCache", "outRecordCache"})
    public void delete7DAgo() {
        recordMapper.delete7DAgo();
    }
}
