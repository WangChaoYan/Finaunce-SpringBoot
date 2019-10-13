package com.qf.service;

import com.qf.domain.LoanOrder;

import java.util.List;

public interface LoanOrderService {
    List<LoanOrder> loadAllLoanOrder();
}
