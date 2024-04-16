package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MsnInfoMapper {
    // 插入新任务
    void insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                   @Param("uid_msn_starter") long uid_msn_starter);
    // 插入派遣人员
    void insertMsnFamily(long msn_id,String msn_name, long uid_assigned, long uid_msn_starter);

    // 任务状态
    void updateMsnState(long msn_flag, String msn_name, long uid_msn_starter);

    void editMsn(@Param("msn_desc") String msn_desc, @Param("msn_id") long msn_id);

    List<MsnInfo> UidGetMsnId(@Param("uid") long uid);

    void deleteOneMsn(@Param("msn_id") long msn_id);

    void deleteMsnByUid(@Param("uid_msn_starter") long uid_msn_starter);
}
