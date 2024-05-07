package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.mapper.LayoutInfoMapper;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class LayoutRepositoryImpl implements LayoutRepository {
    @Autowired
    LayoutInfoMapper layoutInfoMapper;

    // 废弃
    @Override
    public List<LayoutInfo> findAllLayout(long uid) {
        return layoutInfoMapper.findAllLayout(uid);
    }

    @Override
    @CacheEvict(value = "layoutCache", key = "#uid")
    public void insertLayout(long uid, String layout_name, long layout_size, String layout_img) {
        layoutInfoMapper.insertLayout(uid,layout_name,layout_size,layout_img);
    }

    @Override
    public long selectLastInsertId() {
        return layoutInfoMapper.selectLastInsertId();
    }

    @Override
    //@Async("myExecutor")
    @CacheEvict(value = "famNumCache", key = "#layout_id")
    public void insertLayoutFamily(long uid, long layout_id) {
        layoutInfoMapper.insertLayoutFamily(uid,layout_id);
    }

    @Override
    @Cacheable(value = "layoutCache", key = "#uid")
    public List<LayoutInfo> getLayoutId(long uid) {
        return layoutInfoMapper.getLayoutId(uid);
    }

    @Override
    @Cacheable(value = "famNumCache", key = "#layout_id")
    public long getFamNum(long layout_id) {
        return layoutInfoMapper.getFamNum(layout_id);
    }

    @Override
    public List<Map<String, Object>> useLayoutGetUid(long layout_id) {
        return layoutInfoMapper.useLayoutGetUid(layout_id);
    }
}
