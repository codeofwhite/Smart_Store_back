

package canglangpoxiao.smart_store_back.repository.Impl;


import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.entity.com.PostInfo;
import canglangpoxiao.smart_store_back.entity.com.UserPost;
import canglangpoxiao.smart_store_back.mapper.UserMapper;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "userCache")
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserMapper userMapper;
    // 这个已经不用了
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    // 注册
    @Override
    public void register(String u_tel, String upwd) {
        userMapper.register(u_tel, upwd);
    }
    // 登录
    @Override
    public User login(String u_tel, String upwd) {
        return userMapper.login(u_tel,upwd);
    }

    // 更新用户头像
    //@Async
    @Override
    @CacheEvict(key = "#uid")
    public void updateUserImg(String u_img, long uid) {
        userMapper.updateUserImg(u_img, uid);
    }

    @Override
    @Cacheable(key = "#uid")
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
    @CacheEvict(key = "#uid")
    public void updateUserInfo(String uname, String u_img, String u_signature, String u_xp, long uid) {
        userMapper.updateUserInfo(uname,u_img,u_signature,u_xp,uid);
    }

    @Override
    //@Async
    public void inviteFamily(long uid, String invite_code , long layout_id) {
        userMapper.inviteFamily(uid, invite_code, layout_id);
    }

    @Override
    public Long acceptInvite(String invite_code) {
        return userMapper.acceptInvite(invite_code);
    }

    @Override
    public long usePhoneGetUid(long u_tel) {
        return userMapper.usePhoneGetUid(u_tel);
    }

    @Override
    public void addUserPostAccount(long uid) {
        userMapper.addUserPostAccount(uid);
    }

}
