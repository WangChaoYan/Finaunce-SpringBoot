package com.qf.domain;

import lombok.Data;

@Data
public class UserBankCard {
    private Integer userId;
    private String bankCardId;
    private String name;
    private String idCardCode;
    private String bankPreMobile;
}
