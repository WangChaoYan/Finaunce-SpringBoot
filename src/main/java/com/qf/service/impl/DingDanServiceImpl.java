package com.qf.service.impl;

import com.qf.dao.DingDanMapper;
import com.qf.domain.DingDan;
import com.qf.domain.Order;
import com.qf.service.DingDanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/7
 * @Time 9:20
 */
@Service
public class DingDanServiceImpl implements DingDanService {

    @Resource
    DingDanMapper dingDanMapper;
    @Override
    public int insertDingDan(DingDan dingDan) {

        return dingDanMapper.insertNew(dingDan);
    }

    @Override
    public List<Order> selectDingDanByUname(Integer uid) {
        return dingDanMapper.selectDingDanByUname(uid);
    }
}
