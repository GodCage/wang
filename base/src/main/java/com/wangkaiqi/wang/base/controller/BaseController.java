package com.wangkaiqi.wang.base.controller;

import lombok.extern.slf4j.Slf4j;
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
    @GetMapping("/test")
    public Object test(){
        log.info("test===================");
        return "test";
    }
    
}
