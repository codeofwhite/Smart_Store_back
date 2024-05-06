package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LayoutRepository {
    public List<LayoutInfo> findAllLayout(long uid);

    void insertLayout( long uid, String layout_name,
                      long layout_size, String layout_img);

    long selectLastInsertId();

    void insertLayoutFamily(long uid, long layout_id);

    // 搜寻页面的layout_id
    List<LayoutInfo> getLayoutId(long uid);

    public long getFamNum(long layout_id);

    List<Map<String, Object>> useLayoutGetUid(long layout_id);
}
