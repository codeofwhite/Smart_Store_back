package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.entity.StgInfo;

import java.util.List;

public interface StgRepository {
    public List<StgInfo> findAllStg(long uid);

    public List<StgInfo> useRoomFindStg(long room_id);
}
