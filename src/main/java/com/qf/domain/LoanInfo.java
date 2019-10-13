package com.qf.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanInfo {
    private BigDecimal loanAmount;
    private Integer loanStage;
}
