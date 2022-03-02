package com.mth.web.exercise.service;

import com.mth.web.exercise.entity.Brand;
import com.mth.web.exercise.mapper.BrandMapper;
import com.mth.web.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ProjectName: java-web-learning
 * @Author: mth
 * @Description:
 * @Date: 2022/3/1
 * @Version: 1.0
 **/
public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();
    public List<Brand> selectAll() {
        //1.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    /**
     * @param brand brand对象
     */
    public void add(Brand brand) {
        //1.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3.调用方法
        mapper.add(brand);
        //4.提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    /**
     * 根据id查询
     * @return Brand
     */
    public Brand selectById(int id) {
        //1.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3,调用方法
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }
    /**
     * 修改
     * @param
     */
    public void update(Integer id,String brandName, String companyName,Integer ordered,String description,Integer status) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(id,brandName,companyName,ordered,description,status);
        sqlSession.commit();
        sqlSession.close();
    }

    public boolean deleteById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.deleteById(id);
        sqlSession.close();
        return brand == null;
    }


}
