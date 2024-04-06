package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import canglangpoxiao.smart_store_back.mapper.LayoutInfoMapper;
import canglangpoxiao.smart_store_back.repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class LayoutRepositoryImpl implements LayoutRepository {
    @Autowired
    LayoutInfoMapper layoutInfoMapper;
    @Override
    public List<LayoutInfo> findAllLayout(long uid) {
        return layoutInfoMapper.findAllLayout(uid);
    }

    @Override
    public void insertLayout(long uid, String layout_name, long layout_size, String layout_img) {
        layoutInfoMapper.insertLayout(uid,layout_name,layout_size,layout_img);
    }
}