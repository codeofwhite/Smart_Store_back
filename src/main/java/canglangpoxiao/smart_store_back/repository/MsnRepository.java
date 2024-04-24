package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface MsnRepository {
    void insertMsn(String msn_name, String msn_desc, long uid_assigned, long uid_msn_starter, Date dispatch_time, long layout_id);

    void insertMsnFamily(long msn_id, String msn_name, long uid_assigned, long uid_msn_starter);

    void editMsn(String msn_desc, long msn_id);

    List<MsnInfo> UidGetMsnId(long uid);

    void deleteOneMsn(long msn_id);

    void deleteMsnByUid(long uid_msn_starter);

    List<MsnInfo> selectMsn(long layout_id);
}
