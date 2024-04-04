package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.mapper.RoomInfoMapper;
import canglangpoxiao.smart_store_back.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository{

    @Autowired
    RoomInfoMapper roomInfoMapper;

    @Override
    public List<RoomInfo> findAllRoom(long uid) {
        return roomInfoMapper.findAllRoom(uid);
    }
}
