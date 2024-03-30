package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    void register(String uid, String uname,String upwd);
    User login(@Param("uid") String uid, @Param("upwd") String upwd);
}
