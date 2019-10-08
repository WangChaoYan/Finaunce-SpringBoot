package com.qf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author HeXiaoH
 * @date 2019/10/4 8:56
 */
@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer aid;
    private String aname;
    private String apassword;
    private Date createtime;
    private String email;
}
