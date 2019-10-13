package com.qf.service.impl;

import com.qf.dao.LoanOrderMapper;
import com.qf.domain.LoanOrder;
import com.qf.service.LoanOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanOrderServiceImpl implements LoanOrderService {
    @Autowired
    private LoanOrderMapper loanOrderMapper;
    @Override
    public List<LoanOrder> loadAllLoanOrder() {
        return loanOrderMapper.loadAllLoanOrder();
    }
}
