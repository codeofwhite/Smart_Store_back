package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoomRepository {
    public List<RoomInfo> findAllRoom(long uid);

    public List<RoomInfo> useLayoutFindRoom(long layout_id);

    void insertRoom (long uid, String room_name, long layout_id);
}
