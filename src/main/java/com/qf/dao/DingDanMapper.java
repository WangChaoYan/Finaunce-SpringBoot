package com.qf.dao;

import com.qf.domain.DingDan;
import com.qf.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/6
 * @Time 9:55
 */
@Mapper
public interface DingDanMapper {

   int insertNew(DingDan dingDan);

   List<Order> selectDingDanByUname(Integer uid);
}
