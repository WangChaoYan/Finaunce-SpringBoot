package com.qf.dao;

import com.qf.domain.DingDan;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小宝
 * @date 2019/10/6
 * @Time 9:55
 */
@Mapper
public interface DingDanMapper {

   int insertNew(DingDan dingDan);
}
