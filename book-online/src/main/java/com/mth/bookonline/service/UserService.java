package com.mth.bookonline.service;

import com.mth.bookonline.entity.User;

import java.util.List;

/**
 * @ProjectName: JavaWebDev
 * @Author: mth
 * @Description:
 * @Date: 2022/2/24
 * @Version: 1.0
 **/
public class UserService {
    private List<User> userList;

    /**
     * @param userList
     */
//    给用户列表变量传值
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * @param account
     * @param password
     * @return
     */

    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
