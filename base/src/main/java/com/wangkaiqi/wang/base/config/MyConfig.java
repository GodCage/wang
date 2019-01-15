package com.wangkaiqi.wang.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangkaiqi
 * @date Created in 2019/1/3 16:42
 */
@Configuration
@EnableWebMvc
class MyConfig implements WebMvcConfigurer {
    /**
     * 跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true).maxAge(3600);
    }
    
}
