package com.mth.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/2/28
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    //用户id
    private Integer id;
    //用户名称
    private String username;
    //用户密码
    private String password;
}
