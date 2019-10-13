package com.qf.domain;

import javax.persistence.*;

import lombok.Data;


/**
 * @Author 杨小柒丶
 * @Date 2019/10/6
 * @Time 22:20
 */
@Entity
@Table(name ="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private Integer id;
    private String pname;
    private String pinfomation;
    private Float rate;
    private Integer days;
    private Integer limits;
    private Integer status;
}
