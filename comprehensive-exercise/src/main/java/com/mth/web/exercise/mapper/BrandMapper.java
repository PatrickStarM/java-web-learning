package com.mth.web.exercise.mapper;

import org.apache.ibatis.annotations.*;
import com.mth.web.exercise.entity.Brand;

import java.util.List;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/1
 * @Version: 1.0
 **/
public interface BrandMapper {

    /**
     * 查询所有
     *
     * @return List<Brand>
     */
    @Select(" SELECT * FROM tb_brand ORDER BY ordered ")
    List<Brand> selectAll();
    /**
     * 新增
     *
     * @param brand brand对象
     */
    @Insert("INSERT INTO tb_brand VALUES (null,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);
    /**
     * 根据id查询
     *
     * @param id 主键id
     * @return Brand对象
     */
    @Select("SELECT * FROM tb_brand WHERE id = #{id} ")
    Brand selectById(int id);
    /**
     * 根据id修改
     *
     * @param
     */
    @Select("UPDATE tb_brand SET brandName = #{brandName},companyName=#{companyName},ordered=#{ordered},description=#{description},status=#{status} WHERE id=#{id} ")
    Brand update(@Param("id") Integer id
            ,@Param("brandName") String brandName
            ,@Param("companyName") String companyName
            ,@Param("ordered") Integer ordered
            ,@Param("description") String description
            ,@Param("status") Integer status
    );

    @Select("DELETE FROM tb_brand WHERE id = #{id} ")
    Brand deleteById(int id);


}
