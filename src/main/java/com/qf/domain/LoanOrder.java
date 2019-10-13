package com.qf.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class LoanOrder {
    private Integer loanOrderId;
    private BigDecimal loanAmount;
    private Integer loanStage;
    private BigDecimal repaymentAmount;
    private String userBankcardId;
    private String loanDate;
    private Integer uid;
    private Integer status;
    public void setLoanDate(Date date){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        String time = dateformat.format(date);
        this.loanDate=time;
    }
}
