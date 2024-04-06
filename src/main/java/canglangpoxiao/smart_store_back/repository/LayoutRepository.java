package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;

import java.util.List;

public interface LayoutRepository {
    public List<LayoutInfo> findAllLayout(long uid);

    void insertLayout( long uid, String layout_name,
                      long layout_size, String layout_img);
}
