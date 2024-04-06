package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.mapper.ItemInfoMapper;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
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
    public List<ItemInfo> useStgFindItem(long stg_id) {
        return itemInfoMapper.useStgFindItem(stg_id);
    }

    @Override
    public void deleteItem(long it_id) {
        itemInfoMapper.deleteItem(it_id);
    }

    @Override
    public void insertItem(String it_name, long it_size, String it_type ,
                           java.sql.Date best_before, java.sql.Date date_in_produced,
                           String it_img, long stg_id, long uid) {
        itemInfoMapper.insertItem(it_name,it_size,it_type,best_before,date_in_produced,it_img,stg_id,uid);
    }
}
