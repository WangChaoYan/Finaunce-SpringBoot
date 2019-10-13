package com.qf.dao;

import com.qf.domain.LoanProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoanProductMapper {
    LoanProduct loadLoanProduct();
    Integer updateLoanProduct(LoanProduct loanProduct);
}
