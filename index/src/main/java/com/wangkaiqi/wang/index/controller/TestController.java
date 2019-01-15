package com.wangkaiqi.wang.index.controller;

import com.wangkaiqi.wang.index.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wangkaiqi
 * @date Created in 2018/12/24 16:01
 */
@RestController
@Slf4j
public class TestController {
    
    @GetMapping("/ip")
    public Object test(HttpServletRequest request) throws IOException {
        
        return IpUtil.getRemoteIp(request);
    }
    private static String getClientIp(HttpServletRequest request) {
        
        String remoteAddr = "";
        
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        
        return remoteAddr;
    }
    @GetMapping("/error")
    public Object error(){
        log.info("test===================");
        return "error";
    }
}
