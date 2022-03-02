package com.mth.web.exercise.mapper;

import com.mth.web.exercise.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/2/28
 * @Version: 1.0
 **/
public interface UserMapper {
    /**
     * @param username 用户名
     * @param password 密码
     * @return user
     */
    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password}")
    User findUser(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     *
     * @param username 用户名
     * @return 查询到的用户对象
     */
    @Select("SELECT * FROM tb_user WHERE username = #{username} ")
    User selectByUsername(String username);

    /**
     * 添加用户
     *
     * @param user 用户对象
     */
    @Insert("INSERT INTO tb_user VALUES (null,#{username},#{password})")
    void add(User user);
}
