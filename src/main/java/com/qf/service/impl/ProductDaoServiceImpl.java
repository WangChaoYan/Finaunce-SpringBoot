package com.qf.service.impl;

import com.qf.dao.ProductDao;
import com.qf.domain.Product;
import com.qf.service.ProductDaoService;
import com.qf.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/13
 * @Time 19:44
 */
@Service
public class ProductDaoServiceImpl implements ProductDaoService{
    @Resource
    private ProductDao productDao;

    @Override
    public List<Product> FindAll() {
        return  productDao.findAll();
    }

    @Override
    public void del(Integer pid) {
        productDao.deleteById(pid);
    }

    @Override
    public Product add(Product product) {

        return productDao.save(product);
    }

    @Override
    public Product update(Product product)
    {
        return productDao.saveAndFlush(product);
    }

    @Override
    public Product findById(Integer pid)
    {
        return productDao.findById(pid).get();
    }

    @Override
    public List<Product> likeFind( Integer id) {
        return productDao.findByIdLike(id);
    }
}
