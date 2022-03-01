package com.mth.web.exercise.service;

import com.mth.web.exercise.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/2/28
 * @Version: 1.0
 **/
@Slf4j
class UserServiceTest {

    @Test
    void login() {
        UserService userService = new UserService();
        User user = userService.login("zhangsan", "123");
        if (user != null) {
            log.info(String.valueOf(user));
        }
    }

}