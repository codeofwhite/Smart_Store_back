package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.mapper.ItemInfoMapper;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    ItemInfoMapper itemInfoMapper;

    @Override
    public List<ItemInfo> findAllItem(long uid) {
        return itemInfoMapper.findAllItem(uid);
    }

    @Override
    public List<ItemInfo> useStgFindItem(long stg_id, long uid) {
        return itemInfoMapper.useStgFindItem(stg_id, uid);
    }

    @Override
    public void deleteItem(long it_id, long uid) {
        itemInfoMapper.deleteItem(it_id, uid);
    }

    @Override
    public void insertItem(ItemInfo itemInfo) {
        itemInfoMapper.insertItem(itemInfo);
    }
}
