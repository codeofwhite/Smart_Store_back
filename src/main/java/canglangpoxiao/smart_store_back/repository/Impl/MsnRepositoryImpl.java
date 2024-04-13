package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.mapper.MsnInfoMapper;
import canglangpoxiao.smart_store_back.repository.MsnRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MsnRepositoryImpl implements MsnRepository {
    @Autowired
    MsnInfoMapper msnInfoMapper;


    @Override
    public void insertMsn(String msn_name, String msn_desc, long uid_msn_starter) {
        msnInfoMapper.insertMsn(msn_name,   msn_desc,  uid_msn_starter);
    }

    @Override
    public void insertMsnFamily(String msn_name, long uid_assigned, long uid_msn_starter) {
        msnInfoMapper.insertMsnFamily(msn_name,uid_assigned, uid_msn_starter);
    }

    @Override
    public void updateMsnState(long msn_flag, String msn_name, long uid_msn_starter){
        msnInfoMapper.updateMsnState(msn_flag,msn_name,uid_msn_starter);
    }
}
