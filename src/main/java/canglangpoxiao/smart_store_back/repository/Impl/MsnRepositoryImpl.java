package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import canglangpoxiao.smart_store_back.mapper.MsnInfoMapper;
import canglangpoxiao.smart_store_back.repository.MsnRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class MsnRepositoryImpl implements MsnRepository {
    @Autowired
    MsnInfoMapper msnInfoMapper;


    // 插入新的任务
    @Override
    public void insertMsn(String msn_name, String msn_desc, String uid_assigned, long uid_msn_starter,
                          Date dispatch_time, long layout_id) {
        msnInfoMapper.insertMsn(msn_name, msn_desc, uid_assigned, uid_msn_starter, dispatch_time, layout_id);
    }

    // 辅助，得到msn_id
    @Override
    public long selectLastMsnInsertId(){
        return msnInfoMapper.selectLastMsnInsertId();
    }

    // 编辑任务
    @Async
    @Override
    public void editMsn(long msn_id, String msn_name, String msn_desc, long msn_flag) {
        msnInfoMapper.editMsn(msn_id, msn_name, msn_desc, msn_flag);
    }

    // 删除一个任务，用msn_id
    @Async
    @Override
    public void deleteOneMsn(long msn_id){
        msnInfoMapper.deleteOneMsn(msn_id);
    }

    // 删除全部任务
    @Override
    public void deleteMsnByUid(long uid_msn_starter){
        msnInfoMapper.deleteMsnByUid(uid_msn_starter);
    }

    @Override
    public List<MsnInfo> selectMsn(long layout_id) {
        return msnInfoMapper.selectMsn(layout_id);
    }
}
