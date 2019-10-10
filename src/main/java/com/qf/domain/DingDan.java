package com.qf.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author 小宝
 * @date 2019/10/6
 * @Time 9:52
 */

@Data
public class DingDan {

    private Integer id;
    private String uname;
    private String pname;
    private Date time;
    private Long money;
    private Integer status;
}
