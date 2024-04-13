package canglangpoxiao.smart_store_back.repository;

import org.apache.ibatis.annotations.Param;

public interface MsnRepository {
    void insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                   @Param("uid_msn_starter") long uid_msn_starter);

    void insertMsnFamily(String msn_name, long uid_assigned, long uid_msn_starter);

    // 任务状态
    void updateMsnState(long msn_flag, String msn_name, long uid_msn_starter);
}
