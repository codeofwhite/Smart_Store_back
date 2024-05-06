package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import canglangpoxiao.smart_store_back.mapper.MsnInfoMapper;
import canglangpoxiao.smart_store_back.repository.MsnRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    @CacheEvict(value = "msnCache",key = "#layout_id")
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
    @Override
    @CacheEvict(value = "msnCache",key = "#result")
    public long editMsn(long msn_id, String msn_name, String msn_desc, long msn_flag) {
        if(msn_name.isEmpty()){
            msn_name = null;
        }
        if(msn_desc.isEmpty()){
            msn_desc = null;
        }
        long layout_id = msnInfoMapper.msnIdGetLayoutId(msn_id);
        msnInfoMapper.editMsn(msn_id, msn_name, msn_desc, msn_flag);
        return layout_id;
    }

    // 删除一个任务，用msn_id
    @Override
    @CacheEvict(value = "msnCache",key = "#result")
    public long deleteOneMsn(long msn_id){
        long layout_id = msnInfoMapper.msnIdGetLayoutId(msn_id);
        msnInfoMapper.deleteOneMsn(msn_id);
        return layout_id;
    }

    // 删除全部任务
    @Override
    @CacheEvict(value = "msnCache",key = "#result")
    public void deleteMsnByUid(long uid_msn_starter){
        msnInfoMapper.deleteMsnByUid(uid_msn_starter);
    }

    // 找出layout下对应的msn
    @Override
    @Cacheable(value = "msnCache", key = "#layout_id")
    public List<MsnInfo> selectMsn(long layout_id) {
        return msnInfoMapper.selectMsn(layout_id);
    }

    // msn_id得到layout_id
    @Override
    public long msnIdGetLayoutId(long msn_id) {
        return msnInfoMapper.msnIdGetLayoutId(msn_id);
    }
}
