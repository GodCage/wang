package com.wangkaiqi.wang.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableFeignClients({"com.wangkaiqi.wang.base.feign"})
@SpringBootApplication(scanBasePackages = "com.wangkaiqi.wang")
public class IndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndexApplication.class, args);
    }

}

