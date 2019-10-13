package com.qf.dao;

import com.qf.domain.LoanOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoanOrderMapper {
    List<LoanOrder> loadAllLoanOrder();
}
