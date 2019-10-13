package com.qf.service;

import com.qf.domain.Ultable;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/8
 * @Time 21:05
 */
public interface UltableService {
    /*
    查询所有
     */
    List<Ultable> findAll();
    /*
    查询一个
     */
    Ultable findById(Integer uid);
    /*
    修改
     */
    Ultable update(Ultable ultable);
    /*
    删除
     */
    void del(Integer uid);
    /*
    添加
     */
    Ultable add(Ultable ultable);


 }
