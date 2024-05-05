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
    @Cacheable(value = "inRecordCache", key = "#layout_id")
    public List<RecordReturn> rukuRecord(long layout_id) {
        List<RecordReturn> list = recordMapper.rukuRecord(layout_id);
        return list;
    }

    @Override
    @Cacheable(value = "outRecordCache", key = "#layout_id")
    public List<RecordReturn> chukuRecord(long layout_id) {
        List<RecordReturn> list = recordMapper.chukuRecord(layout_id);
        return list;
    }


    // 注意in out record，别打错了
    // 插入一条入库记录
    @Override
    @CacheEvict(value = "inRecordCache", key = "#result")
    public long insertRuRecord(RecordDTO recordDTO) {
        recordMapper.insertRuRecord(recordDTO);
        return recordDTO.getLayout_id();
    }

    @Override
    @CacheEvict(value = "outRecordCache", key = "#result")
    public long updateChuRecord(long uid, long it_id) {
        long layout_id = itIdGetLayoutId(it_id);
        recordMapper.updateChuRecord(uid,it_id);
        return layout_id;
    }

    @Async
    @Override
    @CacheEvict(value = "recordCache", allEntries = true) // 清空整个缓存
    public void delete7DAgo() {
        recordMapper.delete7DAgo();
    }

    @Override
    public long itIdGetLayoutId(long it_id) {
        return recordMapper.itIdGetLayoutId(it_id);
    }
}
