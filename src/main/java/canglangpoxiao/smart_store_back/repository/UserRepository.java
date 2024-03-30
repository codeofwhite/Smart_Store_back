package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public void register(String uid,String uname,String upwd);
    public User login(String uid, String upwd);
    // public Boolean update(String userId,Boolean status);
}