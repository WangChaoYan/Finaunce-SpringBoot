package com.qf.controller;

import com.qf.domain.Product;
import com.qf.service.ProductDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/13
 * @Time 19:48
 */
@RestController
public class ProductDaoController {
    @Autowired
    private ProductDaoService productService;

    @RequestMapping("/findAll")
    public List<Product> findAll() {
        return productService.FindAll();

    }
    @RequestMapping("/add")
    public Product add (@RequestBody Product product ){
        return  productService.add(product);
    }
    @RequestMapping("/del/{pid}")
    public void del(@PathVariable("pid") Integer pid){
        productService.del(pid);
    }
    @RequestMapping("/update")
    public Product update(@RequestBody Product product){
        return  productService.update(product);
    }
    @RequestMapping("/findById")
    public Product findById(@RequestBody Product product){

        return  productService.findById(product.getPid());
    }
    @RequestMapping("/findByIdLike/{id}")
    public List<Product> findByIdLike(@PathVariable("id") Integer id){
        return productService.likeFind(id);
    }
}
