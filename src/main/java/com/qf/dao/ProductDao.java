package com.qf.dao;

import com.qf.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/6
 * @Time 22:30
 */

public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByIdLike(Integer id);
}
