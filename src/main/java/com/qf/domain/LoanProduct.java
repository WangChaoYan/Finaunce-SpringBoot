package com.qf.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanProduct {
    private Integer id;
    private Float rate;
    private BigDecimal limit;

}
