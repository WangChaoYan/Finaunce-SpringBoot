package com.qf.service.impl;

import com.qf.dao.LoanProductMapper;
import com.qf.domain.LoanProduct;
import com.qf.service.LoanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanProductServiceImpl implements LoanProductService {
    @Autowired
    private LoanProductMapper loanProductMapper;
    @Override
    public LoanProduct loadLoanProduct() {
        return loanProductMapper.loadLoanProduct();
    }

    @Override
    public Integer updateLoanProduct(LoanProduct loanProduct) {
        return loanProductMapper.updateLoanProduct(loanProduct);
    }

    @Override
    public BigDecimal repaymentAmount(BigDecimal loanAmount,Integer loanStage) {
        LoanProduct loanProduct=loanProductMapper.loadLoanProduct();
        Float rate =loanProduct.getRate();
        return loanAmount.multiply(BigDecimal.valueOf(Math.pow((1+rate),30.25*loanStage)));
    }
}
