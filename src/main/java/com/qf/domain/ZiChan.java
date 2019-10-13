package com.qf.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ZiChan {
    private BigDecimal zijin;

    public BigDecimal getZichan() {
        return zijin;
    }

    public void setZichan(BigDecimal zichan) {
        this.zijin = zijin;
    }
}
