package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Mapper
public interface MsnInfoMapper {
    // 插入新任务
    void insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc, String uid_assigned,
                   @Param("uid_msn_starter") long uid_msn_starter, Date dispatch_time, long layout_id);

    long selectLastMsnInsertId();

    long editMsn(long msn_id, String msn_name, String msn_desc, long msn_flag);

    long deleteOneMsn(@Param("msn_id") long msn_id);

    void deleteMsnByUid(@Param("uid_msn_starter") long uid_msn_starter);

    List<MsnInfo> selectMsn(@Param("layout_id") long layout_id);

    long msnIdGetLayoutId(long msn_id);
}
