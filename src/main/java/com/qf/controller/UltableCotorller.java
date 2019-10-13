package com.qf.controller;

import com.qf.domain.Ultable;
import com.qf.service.UltableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/8
 * @Time 21:20
 */
@RestController
public class UltableCotorller {
    @Autowired
    private UltableService ultableService;

   @RequestMapping("/findAllUltable")
    public List<Ultable> findAllUltable(){
        return  ultableService.findAll();
   }
   @RequestMapping("/findByIdUltable")
    public Ultable findByIdUltable(@PathVariable("uid") Integer uid){
       return ultableService.findById(uid);
   }
   @RequestMapping("/addUltable")
    public Ultable addUltable(@RequestBody Ultable ultable){
       return  ultableService.add(ultable);
   }
   @RequestMapping("/delUltable/{uid}")
    public void delUltable(@PathVariable("uid")Integer uid){
        ultableService.del(uid);
   }
   @RequestMapping("/updateUltable")
    public Ultable updateUltable(@RequestBody Ultable ultable){
       return  ultableService.update(ultable);
   }

}
