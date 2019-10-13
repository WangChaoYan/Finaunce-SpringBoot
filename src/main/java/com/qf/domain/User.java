package com.qf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String uname;
    private String upassword;
    private Integer usex;
    private Integer uage;
    private String utel;
    private String uemail;
    private String urealname;
    private String ujob;
    private Integer status;          //账户状态
    private String contact;          //联系人
    private String createtime;
}
