package com.wangkaiqi.wang.base.timeservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时执行任务
 * @author wangkaiqi
 * @date Created in 2018/12/29 16:37
 */

@Slf4j
@Component
public class ScheduledService {
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() {
    //    WebSocketServer.sendInfo("定时任务-socket测试");
    }
    
//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
//    }
//
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled2() {
//        log.info("=====>>>>>fixedDelay{}", System.currentTimeMillis());
//    }
}
