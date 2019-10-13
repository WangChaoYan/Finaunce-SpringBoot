package com.qf.domain;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/8
 * @Time 20:57
 */
@Data
@Table(name = "ultable")
@Entity
public class Ultable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private Integer lid;
    @Column(name = "max_borrow")
    private Integer borrow;
    private Integer money;
    @Column(name = "last_time")
    private Date time;

}
