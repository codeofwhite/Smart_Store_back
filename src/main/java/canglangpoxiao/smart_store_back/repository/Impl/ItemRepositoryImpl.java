package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.ItAttribute;
import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.mapper.ItemInfoMapper;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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
    public void deleteItem(long it_id, long uid) {
        itemInfoMapper.deleteItem(it_id, uid);
    }

    @Override
    public void insertItem(ItemInfo itemInfo) {
        itemInfoMapper.insertItem(itemInfo);
    }

    @Override
    public Date getBestBefore(long item_id) {
        return itemInfoMapper.getBestBefore(item_id);
    }

    @Override
    public List<ItemInfo> findFavItem(long layout_id) {
        return itemInfoMapper.findFavItem(layout_id);
    }

    @Override
    public long getItemNum(long layout_id) {
        return itemInfoMapper.getItemNum(layout_id);
    }

    @Override
    public ItAttribute getItemAttribute(String itemName) {
        return itemInfoMapper.getItemAttribute(itemName);
    }

    @Override
    public void ChuItem(long it_id) {
        itemInfoMapper.ChuItem(it_id);
    }

    @Override
    public void updateItemImg(String it_img, long it_id) {
        itemInfoMapper.updateItemImg(it_img, it_id);
    }
}
