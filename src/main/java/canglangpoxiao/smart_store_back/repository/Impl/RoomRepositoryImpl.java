package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.mapper.RoomInfoMapper;
import canglangpoxiao.smart_store_back.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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

    @Override
    public List<RoomInfo> useLayoutFindRoom(long layout_id) {
        return roomInfoMapper.useLayoutFindRoom(layout_id);
    }

    @Async
    @Override
    public void insertRoom(long uid, String room_name, long layout_id) {
        roomInfoMapper.insertRoom(uid, room_name, layout_id);
    }
}
