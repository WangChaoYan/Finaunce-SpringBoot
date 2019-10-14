package com.qf.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tradtime;
}
