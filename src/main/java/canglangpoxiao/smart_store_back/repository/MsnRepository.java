package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsnRepository {
    void insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                   @Param("uid_msn_starter") long uid_msn_starter);

    void insertMsnFamily(long msn_id, String msn_name, long uid_assigned, long uid_msn_starter);

    // 任务状态
    void updateMsnState(long msn_flag, String msn_name, long uid_msn_starter);

    void editMsn(String msn_desc, long msn_id);

    List<MsnInfo> UidGetMsnId(long uid);

    void deleteOneMsn(long msn_id);

    void deleteMsnByUid(long uid_msn_starter);
}
