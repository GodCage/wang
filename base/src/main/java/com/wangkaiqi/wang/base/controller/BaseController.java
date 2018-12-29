package com.wangkaiqi.wang.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.wangkaiqi.wang.base.feign.BaseFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkaiqi
 * @date Created in 2018/12/25 14:24
 */
@RestController
@RequestMapping("/base")
@Slf4j
public class BaseController {
    @Autowired
    BaseFeign baseFeign;
    
    @GetMapping("/test")
    public Object test(){
        log.info("test===================");
        return "test";
    }
    @GetMapping("/feign")
    public Object test2(){
        log.info("test===================");
        JSONObject jsonObject = new JSONObject();
        //接受短信的用户手机号码
        jsonObject.put("mobile","18816271671");
        //您申请的短信模板ID，根据实际情况修改
        jsonObject.put("tpl_id","126383");
        //您设置的模板变量，根据实际情况修改
        jsonObject.put("tpl_value","#code#=1314520");
        //应用APPKEY(应用详细页查询)
        jsonObject.put("key","b14b5b5434306691937d30cc264adc3a");
        return baseFeign.sendMessage(jsonObject);
    }
    
}
