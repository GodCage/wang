package com.wangkaiqi.wang.index.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Map;


/**
 * @author wangkaiqi
 * @date Created in 2019/1/18 10:45
 */
@Slf4j
@Component
public class ElasticsearchApi {
    @Autowired
    Client client;
    String INDEX = "index_001";
    String TYPE = "type_001";
    
    public void setData(Map map)  {
        log.info("插入数据开始");
        IndexResponse indexResponse = client.prepareIndex("index_001", "type_001")
                .setSource(map)
                .get();
        log.info("插入数据成功：{}",indexResponse.toString());
    }
    public void getData()  {
        log.info("开始查询：{}");
        SearchResponse searchResponse = client.prepareSearch(INDEX).setTypes(TYPE)
                .setFrom(0)
                .setSize(10)
                .get();
        log.info("查询数据：{}",searchResponse.toString());
        
    }
}
