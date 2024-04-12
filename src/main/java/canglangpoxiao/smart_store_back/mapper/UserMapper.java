package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.User;
import canglangpoxiao.smart_store_back.entity.UserPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    // 找到全部用户
    List<User> findAll();
    // 注册
    void register(@Param("u_tel") String u_tel, @Param("upwd") String upwd);

    //登录
    User login(@Param("u_tel") String u_tel, @Param("upwd") String upwd);

    // 上载用户图片
    void updateUserImg(@Param("u_img") String u_img, @Param("uid") long uid);

    // 得到用户页面需要的
    List<User> getUserInfo(@Param("uid") long uid);

    // 得到用户post页面需要的
    List<UserPost> getPUserInfo(@Param("uid") long uid);
}
