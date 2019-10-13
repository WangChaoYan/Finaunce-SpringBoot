package com.qf.service.impl;

import com.qf.Response.ResponseUser;
import com.qf.dao.DingdanRepository;
import com.qf.dao.LoanOrderMapper;
import com.qf.dao.UserManageMapper;
import com.qf.domain.DingDan;
import com.qf.domain.LoanOrder;
import com.qf.domain.User;
import com.qf.domain.ZiChan;
import com.qf.service.UserManageService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserManageMapper userManageMapper;


    public ResponseUser findAll(Integer page, Integer size) {//查
        Pageable pages=PageRequest.of(page-1,size);
        Page<User> all = userManageMapper.findAll(pages);
        ResponseUser res=new ResponseUser();
        res.setList(all.getContent());
        res.setTotal(all.getTotalElements());

        return res;
    }

    public User save(User user) {//新增
        String upassword = user.getUpassword();
        String hashupassword="MD5";
        int hashIterations =1024;
        //使用登录名作为salt
        ByteSource bytes = ByteSource.Util.bytes(user.getUname());
        SimpleHash simpleHash=new SimpleHash(hashupassword,upassword,bytes,hashIterations);
        user.setUpassword(simpleHash.toString());//加密后放回去
       Date date=new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        String time = dateformat.format(date);

        user.setCreatetime(time);

        User save = userManageMapper.save(user);
        if(save!=null){
            return save;
        }
        return null;
    }

    public String  managedelete(User user) {//也可以直接对象删
        userManageMapper.delete(user);
        return "删除成功";
    }

    public User selectById(User user) {
        Optional<User> byId = userManageMapper.findById(user.getUid());
        if (byId.isPresent()){
            return   byId.get();
        }
        return null;
    }

    public User manageupdate(User user) {//修改可以改密码的版本
        String upassword = user.getUpassword();
        String hashupassword="MD5";//加密算法
        //把密码改成string
        //String password=upassword;
        //加密次数
        int hashIterations =1024;
        //使用登录名作为salt  盐
        ByteSource bytes = ByteSource.Util.bytes(user.getUname());
        SimpleHash simpleHash=new SimpleHash(hashupassword,upassword,bytes,hashIterations);
        user.setUpassword(simpleHash.toString());//jiami加密的密码放回去

        User user1 = userManageMapper.saveAndFlush(user);
        return user1;
    }

    @Override
    public List<User> findUserOne(User user) {//Optional集合前台不指导怎末取，这样可以转换到list集合，使用add（）方法放入list集合
        List<User> list=new ArrayList<>();
        Optional<User> byId = userManageMapper.findById(user.getUid());
        if (byId.isPresent()){
            list.add(byId.get());
            return list;
        }
        return null;
    }

/*
*
* 以下是资金展示，计算
*
* */
    @Autowired
    private LoanOrderMapper loanOrderMapper;
    @Autowired
    private DingdanRepository dingdanRepository;
    @Override
    public ZiChan manageEAM() {//
        
        List<DingDan> list=dingdanRepository.findAll();

        List<LoanOrder> list1=loanOrderMapper.loadAllLoanOrder();

        ZiChan countMoney=new ZiChan();
        BigDecimal cmoney=new BigDecimal("5000000");
        
        for (DingDan cm:list){
            if (cm.getMoney()==null){
                cm.setMoney(new BigDecimal("0"));
            }
            cmoney=cmoney.add(cm.getMoney());
            countMoney.setZijin(cmoney);
            
        }

        for (LoanOrder cm:list1){
            if (cm.getLoanAmount()==null){
                cm.setLoanAmount(new BigDecimal("0"));
            }
            cmoney=cmoney.subtract(cm.getLoanAmount());
            countMoney.setZijin(cmoney);
        }
        //return cmoney;
        return countMoney;
    }

    @Override
    public ResponseUser manageDingdan(Integer page,Integer size) {
        
        PageRequest of = PageRequest.of(page - 1, size);
        Page<DingDan> all = dingdanRepository.findAll(of);
        ResponseUser res=new ResponseUser();
        res.setTotal(all.getTotalElements());
        res.setList(all.getContent());
        return  res;
    }

    @Override
    public List<LoanOrder> manageLoanOrder() {
        List<LoanOrder> loanOrders = loanOrderMapper.loadAllLoanOrder();
        //System.out.println(loanOrders);
        if (!loanOrders.isEmpty()) {
           
            return loanOrders;
        }
        return null;
    }


    }
