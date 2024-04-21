package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepositoryl;
    // 扫出用户信息
    @PostMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo(@RequestParam long uid){
        List<User> list = userRepositoryl.getUserInfo(uid);
        return list;
    }

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(String uname, MultipartFile u_img, String u_signature, String u_xp,@RequestParam long uid) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI5tNsiEWTM57UKJPfypJQ";
        String accessKeySecret = "e2qNeyRn5OGFoh4b6ZX2JRAWNPlEql";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 判断为空的时候
        if("".equals(uname)){
            uname = null;
        }

        if("".equals(u_signature)){
            u_signature = null;
        }

        if("".equals(u_xp)){
            u_xp = null;
        }


        String u_imgString;
        if("".equals(u_img)){
            u_imgString = null;
        } else if (u_img == null) {
            u_imgString = null;
        } else {
            //2、将上传的图片存储到云端
            InputStream inputStream = u_img.getInputStream();
            // 获取当前时间
            Date date = new Date();
            ossClient.putObject("smartstorezzw", date + ".jpg", inputStream);
            u_imgString = "https://smartstorezzw.oss-cn-hangzhou.aliyuncs.com/" + date + ".jpg";
        }

        userRepositoryl.updateUserInfo(uname,u_imgString,u_signature,u_xp,uid);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "更新成功";
    }
}
