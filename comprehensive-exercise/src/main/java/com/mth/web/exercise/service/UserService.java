package com.mth.web.exercise.service;

import com.mth.web.exercise.entity.User;
import com.mth.web.exercise.mapper.UserMapper;
import com.mth.web.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/2/28
 * @Version: 1.0
 **/
public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * @param username 用户名
     * @param password 用户密码
     * @return 登录成功的用户对象
     */
    public User login(String username, String password) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用方法
        User user = mapper.findUser(username, password);
        //5.释放资源
        sqlSession.close();
        return user;
    }

    /**
     * @param user 注册用户对象
     * @return 是否成功
     */
    public Boolean register(User user) {
        //1.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.判断用户名是否存在
        User user1 = mapper.selectByUsername(user.getUsername());
        if (user1 == null) {
            //用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return user1 == null;
    }

}
