package com.wechat.controller;

import com.wechat.model.Lost_item;
import com.wechat.service.Lost_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Maincontroller {

    @Autowired
    private Lost_itemService lost_itemService;

    @RequestMapping("/getInfo.do")
    @ResponseBody
    public Lost_item getStudent(){
       Lost_item l=lost_itemService.findById(1);
        return l;
    }


}
