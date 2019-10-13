package com.qf.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "dingdan")
public class DingDan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uname;
    private  String pname;
    private Date time;
    private BigDecimal money;//金钱

    private Integer status;
}
