package com.qf.dao;

import com.qf.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
        Order findByTradnum(String tradnum);

        List<Order> findAllByUid(Integer uid);


}
