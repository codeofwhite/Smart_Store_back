package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    List<Record> rukuRecord(@Param("uid") long uid);
    List<Record> chukuRecord(@Param("uid") long uid);

    void insertRuRecord(RecordDTO recordDTO);

    // 更新出库记录
    void updateChuRecord(@Param("uid") long uid, @Param("it_id") long it_id);
}
