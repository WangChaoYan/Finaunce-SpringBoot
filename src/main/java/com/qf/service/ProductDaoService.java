package com.qf.service;

import com.qf.domain.Product;

import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/13
 * @Time 19:43
 */
public interface ProductDaoService {
        /*
    查询全部
     */

    List<Product> FindAll();
    /*
    删除
     */

    void del(Integer pid);
    /*
    添加
     */
    Product add(Product product);
    /*
    修改
     */
    Product update(Product product);
    /*
    根据id查询
     */
    Product findById(Integer pid);
    /*
    模糊查询
     */

    List<Product> likeFind(Integer id);
}
