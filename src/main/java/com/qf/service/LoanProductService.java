package com.qf.service;

import com.qf.domain.LoanProduct;

import java.math.BigDecimal;

public interface LoanProductService {
    LoanProduct loadLoanProduct();
    Integer updateLoanProduct(LoanProduct loanProduct);
    BigDecimal repaymentAmount(BigDecimal loanAmount, Integer loanStage);
}
