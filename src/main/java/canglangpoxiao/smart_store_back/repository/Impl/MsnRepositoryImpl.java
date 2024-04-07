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
    public void insertMsn(String msn_name, String msn_desc, long uid_msn_starter, long uid_assigned) {
        msnInfoMapper.insertMsn(msn_name,   msn_desc,  uid_msn_starter,  uid_assigned);
    }
}
