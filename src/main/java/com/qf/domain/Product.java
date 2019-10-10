package com.qf.domain;

import lombok.Data;

/**
 * @author 小宝
 * @date 2019/9/30
 * @Time 15:25
 */


//产品类

@Data
public class Product {
    private Integer pid;         //序号
    private Integer id;          //产品id
    private String pname;       //产品名称
    private String pinfomation; //基础产品信息
    private String rate;      //利率
    private String days;      //周期
    private Integer limits;    //限额
    private Integer status;   //1理财  2投资
    private String number;
    private String address;
    private String account;
}
