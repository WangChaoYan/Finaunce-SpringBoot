package com.qf.service;

import com.qf.domain.UserBankCard;

import java.util.List;

public interface UserBankCardService {
    Integer addUserBankCard(UserBankCard userBankCard);
    String verifyUserBankCard(UserBankCard userBankCard);
    List<UserBankCard> loadAllUserBankCard();
}
