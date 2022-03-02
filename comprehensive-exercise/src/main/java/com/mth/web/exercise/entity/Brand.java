package com.mth.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description: 品牌实体类
 * @Date: 2022/3/1
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Brand {
    //id主键
    private Integer id;
    //品牌名称
    private String brandName;
    //企业名称
    private String companyName;
    //排序字段
    private Integer ordered;
    //描述信息
    private String description;
    //状态：0.禁用 1.启用
    private Integer status;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
