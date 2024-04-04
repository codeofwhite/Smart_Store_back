package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    void register(@Param("u_tel") String u_tel, @Param("upwd") String upwd);

    User login(@Param("u_tel") String u_tel, @Param("upwd") String upwd);
}
