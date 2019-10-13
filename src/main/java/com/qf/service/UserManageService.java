package com.qf.service;

import com.qf.Response.ResponseUser;
import com.qf.domain.DingDan;
import com.qf.domain.LoanOrder;
import com.qf.domain.User;
import com.qf.domain.ZiChan;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface UserManageService {

    ResponseUser findAll(Integer page, Integer size);

    User save(User user);

    String managedelete(User user);

    User selectById(User user);

    User  manageupdate(User user);


    List<User> findUserOne(User user);

    /*
    *下面是资金管理
    */

    ZiChan manageEAM();


    List<LoanOrder> manageLoanOrder();

    ResponseUser manageDingdan(Integer page, Integer size);
}
