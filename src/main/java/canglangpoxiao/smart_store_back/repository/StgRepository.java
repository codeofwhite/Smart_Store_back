package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.RoomInfo;
import canglangpoxiao.smart_store_back.entity.StgInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StgRepository {
    public List<StgInfo> findAllStg(long uid);

    public List<StgInfo> useRoomFindStg(long room_id);

    List<StgInfo> findFavStg(@Param("layout_id") long layout_id);

    long getStgNum(@Param("layout_id") long layout_id);

    void insertStg(long uid, String stg_name,
                   long room_id, long layout_id);
}
