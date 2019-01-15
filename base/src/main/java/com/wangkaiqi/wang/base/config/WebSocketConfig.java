package com.wangkaiqi.wang.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket配置
 * @author wangkaiqi
 * @date Created in 2018/12/25 15:47
 */
@Configuration
public class WebSocketConfig {
    
        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            return new ServerEndpointExporter();
        }
}
