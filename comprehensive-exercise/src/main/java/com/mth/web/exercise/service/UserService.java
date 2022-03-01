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
}
