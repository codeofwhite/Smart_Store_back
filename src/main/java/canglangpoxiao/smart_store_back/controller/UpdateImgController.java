package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.repository.UserRepository;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@RestController
public class UpdateImgController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/UpdateUserImg", method = RequestMethod.POST)
    @ResponseBody
    void testUpdateOss(@Param("url") String url, @Param("uid") long uid) {


        // Endpoint以杭州为例，其它Region请按实际情况填写。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(url);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 获取当前时间
        Date date = new Date();
        ossClient.putObject("smartstorezzw", date + ".jpg", inputStream);
        userRepository.updateUserImg("https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/" + date + ".jpg", uid);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@Param("uploadfile") MultipartFile uploadfile, @Param("uid") long uid) throws IOException {

        // Endpoint以杭州为例，其它Region请按实际情况填写。

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        //1、输出测试
        System.out.println("==============");
        System.out.println(uploadfile);
        System.out.println(uploadfile.getName());
        System.out.println(uploadfile.getSize());
        //2、将上传的图片存储到云端
        InputStream inputStream = uploadfile.getInputStream();

        // 获取当前时间
        Date date = new Date();
        ossClient.putObject("smartstorezzw", date + ".jpg", inputStream);
        userRepository.updateUserImg("https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/" + date + ".jpg", uid);

        // 关闭OSSClient。
        ossClient.shutdown();

        //4、返回成功信息
        return "success";
    }
}
