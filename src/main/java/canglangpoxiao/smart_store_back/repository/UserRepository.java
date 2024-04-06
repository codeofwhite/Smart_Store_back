package canglangpoxiao.smart_store_back.repository;

import canglangpoxiao.smart_store_back.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public void register(String u_tel, String upwd);
    public User login(String u_tel, String upwd);

    public void updateUserImg(String u_img, long uid);

}