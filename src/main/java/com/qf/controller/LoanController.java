package com.qf.controller;

import com.qf.domain.LoanInfo;
import com.qf.domain.LoanOrder;
import com.qf.domain.LoanProduct;
import com.qf.domain.UserBankCard;
import com.qf.service.LoanOrderService;
import com.qf.service.LoanProductService;
import com.qf.service.UserBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LoanController {
    @Autowired
    private LoanProductService loanProductService;
    @Autowired
    private UserBankCardService userBankCardService;
    @Autowired
    private LoanOrderService loanOrderService;
    @RequestMapping(value = "/loadloanproduct")
    public LoanProduct loadLoanProduct(){
        return loanProductService.loadLoanProduct();
    }
    @RequestMapping(value = "/repaymentamount")
    public BigDecimal repaymentAmount(@RequestBody LoanInfo loanInfo){
        System.out.println(loanInfo);
        return loanProductService.repaymentAmount(loanInfo.getLoanAmount(),loanInfo.getLoanStage());
    }
    @RequestMapping(value = "/updateloanproduct")
    public Integer updateloanproduct(@RequestBody LoanProduct loanProduct){
        return loanProductService.updateLoanProduct(loanProduct);

    }
    @RequestMapping(value = "/adduserbankcard")
    public Integer addUserBankCard(@RequestBody UserBankCard userBankCard){
        userBankCard.setUserId(1);
        return userBankCardService.addUserBankCard(userBankCard);
    }
    @RequestMapping(value = "/verifyuserbankcard")
    public boolean verifyUserBankCard(@RequestBody UserBankCard userBankCard){
        String result=userBankCardService.verifyUserBankCard(userBankCard);
        String str=result.substring(result.indexOf("message")-4,result.indexOf("message")-3);
        System.out.println(str);
        return str.equals("T")?true:false;
    }
    @RequestMapping(value = "/loadalluserbankcard")
    public List<UserBankCard>  loadAllUserBankCard(){
        return userBankCardService.loadAllUserBankCard();
    }
    @RequestMapping(value = "loadallloanorder")
    public List<LoanOrder> loadAllLoanOrder(){
      return   loanOrderService.loadAllLoanOrder();
    }
}
