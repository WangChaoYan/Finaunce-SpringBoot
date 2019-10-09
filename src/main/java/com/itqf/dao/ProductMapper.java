package com.itqf.dao;

import com.itqf.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 小宝
 * @date 2019/9/30
 * @Time 15:35
 */

//产品接口

@Mapper
public interface ProductMapper {

    List<Product> selectProduct();

    List<Product> selectProductByStatus(Integer status);

    Product selectById(Integer id);

    Product selectProductById(Integer pid);

    List<Product> selectByDays(Integer days);

    //插入一个产品向订单表
}
