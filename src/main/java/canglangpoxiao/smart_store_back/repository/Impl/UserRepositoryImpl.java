

package canglangpoxiao.smart_store_back.repository.Impl;


import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.mapper.UserMapper;
import canglangpoxiao.smart_store_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
