package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.mapper.StgInfoMapper;
import canglangpoxiao.smart_store_back.repository.StgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StgRepositoryImpl implements StgRepository {

    @Autowired
    StgInfoMapper stgInfoMapper;
    @Override
    public List<StgInfo> findAllStg(long uid) {
        return stgInfoMapper.findAllStg(uid);
    }
}
