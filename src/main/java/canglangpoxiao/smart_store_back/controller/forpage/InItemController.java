package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.RecordDTO;
import canglangpoxiao.smart_store_back.entity.ItAttribute;
import canglangpoxiao.smart_store_back.entity.ItemInfo;
import canglangpoxiao.smart_store_back.repository.ItemRepository;
import canglangpoxiao.smart_store_back.repository.RecordRepository;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class InItemController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    RecordRepository recordRepository;
    private final ReentrantLock lock = new ReentrantLock();

    // 插入新的物品
    @Transactional
    @RequestMapping(value = "/insertItem", method = RequestMethod.POST)
    @ResponseBody
    public long insertItem(@RequestBody ItemInfo itemInfo){
        lock.lock();  // 获取锁
        try{
            if (Objects.equals(itemInfo.getBest_before(), null)){
                itemInfo.setBest_before(Date.valueOf("1000-01-01"));
            }
            if(itemInfo.getIt_type() != null) {
                if (itemInfo.getIt_type().isEmpty()) {
                    itemInfo.setIt_type("生活杂物");
                }
            }
            else {
                itemInfo.setIt_type("生活杂物");
            }
            if(itemInfo.getIt_img() != null){
                if(itemInfo.getIt_img().isEmpty()){
                    itemInfo.setIt_img("https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/ItemDefault.png");
                }
            }
            else {
                itemInfo.setIt_img("https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/ItemDefault.png");
            }
            if(itemInfo.getRemark() != null) {
                if (itemInfo.getRemark().isEmpty()) {
                    itemInfo.setRemark("没有特殊标注");
                }
            }else{
                itemInfo.setRemark("没有特殊标注");
            }

            itemRepository.insertItem(itemInfo);
        }
        finally {
            lock.unlock();  // 释放锁
        }

        // 得到插入的it_id
        return itemRepository.selectLastItemInsertId();
    }

    // 上传物品图片
    @PostMapping("/updateItemImg")
    @ResponseBody
    public String updateItemImg(MultipartFile it_img, long it_id) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI5tNsiEWTM57UKJPfypJQ";
        String accessKeySecret = "e2qNeyRn5OGFoh4b6ZX2JRAWNPlEql";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        String it_imgString;
        if("".equals(it_img)){
            it_imgString = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/ItemDefault.png";
        } else if (it_img == null) {
            it_imgString = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/ItemDefault.png";
        } else {
            //2、将上传的图片存储到云端
            InputStream inputStream = it_img.getInputStream();
            // 获取当前时间
            java.util.Date date = new java.util.Date();
            ossClient.putObject("smartstorezzw", date + ".jpg", inputStream);
            it_imgString = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/" + date + ".jpg";
        }

        itemRepository.updateItemImg(it_imgString,it_id);

        // 关闭OSSClient。
        ossClient.shutdown();
        return "更新成功";
    }

    // 得到物品的属性
    @RequestMapping(value = "/getItemAttribute", method = RequestMethod.POST)
    @ResponseBody
    public List<ItAttribute> getItemAttribute(@RequestParam List<String> itemName){
        List<ItAttribute> list = new ArrayList<>();
        List<ItAttribute> listDefault = new ArrayList<>();
        listDefault.add(itemRepository.getItemAttribute("默认物品"));
        System.out.println(itemName.size());
        for (int i =0; i<itemName.size();++i) {
            assert false;
            System.out.println(itemName.get(i));
            list.add(itemRepository.getItemAttribute(itemName.get(i)));
            if(list.get(i) == null){
                System.out.println("调用");
                list.set(i, listDefault.get(0));
            }
        }
        return list;
    }


}
