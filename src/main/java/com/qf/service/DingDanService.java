package com.qf.service;

import com.qf.domain.DingDan;
import com.qf.domain.Order;

import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/7
 * @Time 9:19
 */
public interface DingDanService {

    int insertDingDan(DingDan dingDan);

    List<Order> selectDingDanByUname(Integer uid);


}
