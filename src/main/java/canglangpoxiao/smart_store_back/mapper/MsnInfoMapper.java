package canglangpoxiao.smart_store_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MsnInfoMapper {
    // 插入新任务
    void insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                   @Param("uid_msn_starter") long uid_msn_starter);
    // 插入派遣人员
    void insertMsnFamily(String msn_name, long uid_assigned, long uid_msn_starter);

    // 任务状态
    void updateMsnState(long msn_flag, String msn_name, long uid_msn_starter);
}
