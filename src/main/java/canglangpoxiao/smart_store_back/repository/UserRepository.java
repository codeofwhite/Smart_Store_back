package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.entity.com.UserPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public void register(String u_tel, String upwd);
    public User login(String u_tel, String upwd);

    public void updateUserImg(String u_img, long uid);

    public List<User> getUserInfo(long uid);

    // 得到用户post页面需要的
    List<UserPost> getPUserInfo(long uid);

    void updateUserInfo(String uname, String u_img, String u_signature, String u_xp, long uid);

    void inviteFamily(@Param("uid") long uid, String invite_code, long layout_id);

    Long acceptInvite(@Param("invite_code") String invite_code);

    long usePhoneGetUid(long u_tel);

    void addUserPostAccount(long uid);
}