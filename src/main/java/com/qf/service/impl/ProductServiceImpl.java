package com.qf.service.impl;

import com.qf.dao.ProductDao;
import com.qf.dao.ProductMapper;
import com.qf.domain.Product;
import com.qf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/6
 * @Time 9:33
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Resource
    private ProductMapper productMapper;
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
    @Override
    public List<Product> selectProductByStatus(Integer status) {
        return productMapper.selectProductByStatus(status);
    }

    @Override
    public List<Product> selectProduct() {
        return productMapper.selectProduct();
    }

    @Override
    public Product selectProductById(Integer pid) {
        return productMapper.selectProductById(pid);
    }

    @Override
    public Product selectById(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    public List<Product> selectByDays(Integer days) {
        return productMapper.selectByDays(days);
    }

}
