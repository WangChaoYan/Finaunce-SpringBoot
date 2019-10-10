package com.qf.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private Long money;
    private Integer status;
}
