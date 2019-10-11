package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "course_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orid;
    @Column(name = "trad_num")
    private String tradnum;
    @Column(name = "trad_acount")
    private Float tradacount;
    @Column(name = "trad_status")
    private String tradstatus;
    private Integer uid;
    @Column(name = "trad_cname")
    private String tradcname;
    @Column(name = "trad_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tradtime;
}
