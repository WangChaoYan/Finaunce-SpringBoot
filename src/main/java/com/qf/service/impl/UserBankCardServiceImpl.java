package com.qf.service.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.qf.dao.UserBankCardMapper;
import com.qf.domain.UserBankCard;
import com.qf.service.UserBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class UserBankCardServiceImpl implements UserBankCardService {
    @Autowired
    private UserBankCardMapper userBankCardMapper;
    @Override
    public Integer addUserBankCard(UserBankCard userBankCard) {
        Integer result=0;
        try{
            result=userBankCardMapper.addUserBankCard(userBankCard);
        }catch (Exception e){
        };
        return result;
    }

    @Override
    public String verifyUserBankCard(UserBankCard userBankCard) {
        String result=null;
        try {
            URL url =new URL(" http://apis.haoservice.com/creditop/BankCardQuery/QryBankCardBy4Element?" +
                    "accountNo=" +userBankCard.getBankCardId()+
                    "&name=" +userBankCard.getName()+
                    "&idCardCode=" +userBankCard.getIdCardCode()+
                    "&bankPreMobile=" +userBankCard.getBankPreMobile()+
                    "&key=b28f7488a9584316b5e700f3218c8f78");
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1096.1 Safari/536.6");
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setDoOutput(true);
            if (conn.getResponseCode() == 302) {
                System.out.println(302);
                return null;
            }
            if (conn.getResponseCode() == 200) {
                System.out.println(200);
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer();
            String s = "";
            while ((s = rd.readLine()) != null) {
                sb.append(s);
            }
            // System.out.println(sb);
            if (sb.length() == 0) {
                sb.append("[]");
            }
            result = sb.toString();
            System.out.println(result); //到这里就获取到结果了result是结果
            rd.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
            return result;
    }

    @Override
    public List<UserBankCard> loadAllUserBankCard() {
        return userBankCardMapper.loadAllUserBankCard();
    }
}
