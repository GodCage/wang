package com.wangkaiqi.wang.index.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkaiqi
 * @date Created in 2018/12/24 16:01
 */
@RestController
@Slf4j
public class TestController {
    
    @GetMapping("/test")
    public Object test(){
        log.info("test===================");
        return "test";
    }
    @GetMapping("/error")
    public Object error(){
        log.info("test===================");
        return "error";
    }
}
