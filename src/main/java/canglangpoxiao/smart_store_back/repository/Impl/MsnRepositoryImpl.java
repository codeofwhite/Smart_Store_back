package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import canglangpoxiao.smart_store_back.mapper.MsnInfoMapper;
import canglangpoxiao.smart_store_back.repository.MsnRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MsnRepositoryImpl implements MsnRepository {
    @Autowired
    MsnInfoMapper msnInfoMapper;


    @Override
    public void insertMsn(String msn_name, String msn_desc, long uid_msn_starter) {
        msnInfoMapper.insertMsn(msn_name,   msn_desc,  uid_msn_starter);
    }

    @Override
    public void insertMsnFamily(long msn_id, String msn_name, long uid_assigned, long uid_msn_starter) {
        msnInfoMapper.insertMsnFamily(msn_id, msn_name,uid_assigned, uid_msn_starter);
    }

    @Override
    public void updateMsnState(long msn_flag, String msn_name, long uid_msn_starter){
        msnInfoMapper.updateMsnState(msn_flag,msn_name,uid_msn_starter);
    }

    @Override
    public void editMsn(String msn_desc, long msn_id) {
        msnInfoMapper.editMsn(msn_desc,msn_id);
    }

    @Override
    public List<MsnInfo> UidGetMsnId(long uid) {
        List<MsnInfo> list =  msnInfoMapper.UidGetMsnId(uid);
        return list;
    }

    @Override
    public void deleteOneMsn(long msn_id){
        msnInfoMapper.deleteOneMsn(msn_id);
    }

    @Override
    public void deleteMsnByUid(long uid_msn_starter){
        msnInfoMapper.deleteMsnByUid(uid_msn_starter);
    }
}
