package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    List<Record> rukuRecord(@Param("layout_id") long layout_id);
    List<Record> chukuRecord(@Param("layout_id") long layout_id);

    void insertRuRecord(RecordDTO recordDTO);

    // 更新出库记录
    void updateChuRecord(@Param("uid") long uid, @Param("it_id") long it_id);

    // 删除七天前
    public void delete7DAgo();
}
