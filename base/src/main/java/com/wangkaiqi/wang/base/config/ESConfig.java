package com.wangkaiqi.wang.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author wangkaiqi
 * @date 2018/11/1 17:08
 */
@Slf4j
@Configuration
@ComponentScan
@EntityScan
@EnableElasticsearchRepositories(basePackages = "com.wangkaiqi.wang")
public class ESConfig {

}
