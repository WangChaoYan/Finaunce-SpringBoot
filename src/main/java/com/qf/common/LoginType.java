package com.qf.common;

/**
 * @author HeXiaoH
 * @date 2019/10/9 11:05
 */
public enum  LoginType {
    USER("user"),
    ADMIN("admin");

    private String type;

    private LoginType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }


}
