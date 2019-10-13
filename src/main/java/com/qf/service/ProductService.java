package com.qf.service;

import com.qf.domain.Product;

import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/6
 * @Time 9:31
 */
public interface ProductService {

    List<Product> selectProduct();

    List<Product> selectProductByStatus(Integer status);

    Product selectProductById(Integer pid);

    Product selectById(Integer id);

    List<Product> selectByDays(Integer days);

}
