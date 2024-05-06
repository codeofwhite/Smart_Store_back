package canglangpoxiao.smart_store_back.repository.Impl;

import canglangpoxiao.smart_store_back.entity.ItAttribute;
import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.mapper.ItemInfoMapper;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    ItemInfoMapper itemInfoMapper;

    // 找到用户拥有的所有物品
    @Override
    public List<ItemInfo> findAllItem(long uid) {
        return itemInfoMapper.findAllItem(uid);
    }

    // 用Stg找物品
    @Override
    @Cacheable(value = "itemCache", key = "#stg_id")
    public List<ItemInfo> useStgFindItem(long stg_id) {
        return itemInfoMapper.useStgFindItem(stg_id);

    }

    // 删除物品，废弃
    @Override
    public void deleteItem(long it_id, long uid) {
        itemInfoMapper.deleteItem(it_id, uid);
    }

    // 插入新的物品
    //@Async("myExecutor")
    @Override
    @CacheEvict(value = "itemCache", key = "#result")
    public long insertItem(ItemInfo itemInfo) {
        long stg_id = itemInfo.getStg_id();
        itemInfoMapper.insertItem(itemInfo);
        return stg_id;
    }

    // 得到最佳日期
    @Override
    public Date getBestBefore(long item_id) {
        return itemInfoMapper.getBestBefore(item_id);
    }

    // 找到最爱的物品
    @Override
    public List<ItemInfo> findFavItem(long layout_id) {
        return itemInfoMapper.findFavItem(layout_id);
    }

    // 得到这个场景下的物品总数
    @Override
    public long getItemNum(long layout_id) {
        return itemInfoMapper.getItemNum(layout_id);
    }

    // 得到物品的属性标示
    @Override
    @Cacheable(value = "itemAttributeCache", key = "#root.args[0]", unless = "#result == null")
    public ItAttribute getItemAttribute(String itemName) {
        return itemInfoMapper.getItemAttribute(itemName);
    }

    // 出库物品
    @Override
    @CacheEvict(value = "itemCache", key = "#result")
    public long ChuItem(long it_id) {
        long stg_id = itemInfoMapper.useItIdFindStgId(it_id);
        itemInfoMapper.ChuItem(it_id);
        return stg_id;
    }

    // 更新物品图片
    @Override
    @CacheEvict(value = "itemCache", key = "#result")
    public void updateItemImg(String it_img, long it_id) {
        long stg_id = itemInfoMapper.useItIdFindStgId(it_id);
        itemInfoMapper.updateItemImg(it_img, it_id);
    }

    @Override
    public long selectLastItemInsertId() {
        System.out.println(itemInfoMapper.selectLastItemInsertId());
        return itemInfoMapper.selectLastItemInsertId();
    }

    // 用it_id找到对应的stg_id
    @Override
    public long useItIdFindStgId(long it_id) {
        return itemInfoMapper.useItIdFindStgId(it_id);
    }



}
