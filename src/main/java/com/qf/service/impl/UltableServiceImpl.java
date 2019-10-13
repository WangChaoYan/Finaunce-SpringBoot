package com.qf.service.impl;

import com.qf.dao.UltableDao;
import com.qf.domain.Ultable;
import com.qf.service.UltableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/8
 * @Time 21:12
 */
@Service("ultableServiceImpl")
public class UltableServiceImpl implements UltableService {
    @Autowired
    private UltableDao ultableDao;
    @Override
    public List<Ultable> findAll() {
        return ultableDao.findAll();
    }

    @Override
    public Ultable findById(Integer uid) {

        return ultableDao.findById(uid).get();
    }

    @Override
    public Ultable update(Ultable ultable) {

        return ultableDao.saveAndFlush(ultable) ;
    }

    @Override
    public void del(Integer uid) {
            ultableDao.deleteById(uid);
    }

    @Override
    public Ultable add(Ultable ultable)
    {
        return  ultableDao.save(ultable);
    }
}
