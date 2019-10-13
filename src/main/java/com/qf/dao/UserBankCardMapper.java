package com.qf.dao;

import com.qf.domain.UserBankCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserBankCardMapper {
    Integer addUserBankCard(UserBankCard userBankCard);
    List<UserBankCard> loadAllUserBankCard();
}
