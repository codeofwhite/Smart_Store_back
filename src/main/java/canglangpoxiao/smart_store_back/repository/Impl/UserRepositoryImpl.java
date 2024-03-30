

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
    public void register(String userId, String userName,String password) {
        userMapper.register(userId, userName,password);
    }
    @Override
    public User login(String userId, String password) {
        return userMapper.login(userId,password);
    }

}
