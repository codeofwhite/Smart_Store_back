

package canglangpoxiao.smart_store_back.repository.Impl;


import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.entity.com.UserPost;
import canglangpoxiao.smart_store_back.mapper.UserMapper;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    @Override
    public void register(String u_tel, String upwd) {
        userMapper.register(u_tel, upwd);
    }
    @Override
    public User login(String u_tel, String upwd) {
        return userMapper.login(u_tel,upwd);
    }

    @Override
    public void updateUserImg(String u_img, long uid) {
        userMapper.updateUserImg(u_img, uid);
    }

    @Override
    public List<User> getUserInfo(long uid) {
        List<User> user = userMapper.getUserInfo(uid);
        return user;
    }

    @Override
    public List<UserPost> getPUserInfo(long uid) {
        List<UserPost> list = userMapper.getPUserInfo(uid);
        return list;
    }

    @Override
    public void updateUserInfo(String uname, String u_img, String u_signature, String u_xp, long uid) {
        userMapper.updateUserInfo(uname,u_img,u_signature,u_xp,uid);
    }

    @Override
    public void inviteFamily(long uid, String invite_code) {
        userMapper.inviteFamily(uid, invite_code);
    }

    @Override
    public String acceptInvite(String invite_code) {
        return userMapper.acceptInvite(invite_code);
    }

}
