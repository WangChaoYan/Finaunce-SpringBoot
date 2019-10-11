package com.qf.config;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/11
 * @Time 11:38
 */
@Data
public class AlipayNotifyParam implements Serializable {
    private String app_id;//商户appid
    private Float total_amount; // 支付金额
    private String out_trade_no; // 原支付请求的商户订单号
}
