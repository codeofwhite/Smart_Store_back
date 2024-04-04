package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.RoomInfo;

import java.util.List;

public interface RoomRepository {
    public List<RoomInfo> findAllRoom(long uid);
}
