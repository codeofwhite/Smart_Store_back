package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.mapper.StgInfoMapper;
import canglangpoxiao.smart_store_back.repository.StgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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

    @Override
    public List<StgInfo> useRoomFindStg(long room_id) {
        return stgInfoMapper.useRoomFindStg(room_id);
    }

    @Override
    public List<StgInfo> findFavStg(long layout_id) {
        return stgInfoMapper.findFavStg(layout_id);
    }

    @Override
    public long getStgNum(long layout_id) {
        return stgInfoMapper.getStgNum(layout_id);
    }

    //@Async
    @Override
    public void insertStg(long uid, String stg_name, long room_id, long layout_id) {
        stgInfoMapper.insertStg(uid,stg_name,room_id,layout_id);
    }
}
