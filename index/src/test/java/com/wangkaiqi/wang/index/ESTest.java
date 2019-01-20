package com.wangkaiqi.wang.index;

import com.wangkaiqi.wang.index.elasticsearch.ElasticsearchApi;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ESTest {
    @Autowired
    ElasticsearchApi elasticsearchApi;
    @Test
    public void es_test1(){
        Map<String,Object> persion = new HashMap<>();
        Map<String,Object> car = new HashMap<>();
        Map<String,Object> car2 = new HashMap<>();
        List<Map<String,Object>> cars = new ArrayList<>();
        car.put("pic","http://");
        car.put("color","green");
        car.put("tollNo","苏E82234");
        cars.add(car);

        car2.put("pic","http://");
        car2.put("color","blue");
        car2.put("tollNo","浙E82234");
        cars.add(car2);

        persion.put("name","王五");
        persion.put("age",35);
        persion.put("qq","4566456456");
        persion.put("address","宋泽家园六区");
        persion.put("cars",cars);

        elasticsearchApi.setData(persion);
    }
    @Test
    public void es_test3() {
        elasticsearchApi.getData();
    }

    @Test
    public void es_test4() {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "李");
        // QueryBuilders.multiMatchQuery()
        elasticsearchApi.getData(matchQueryBuilder);
    }
    @Test
    public void es_test5() {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("cars.tollNo", "浙");
        // QueryBuilders.multiMatchQuery()
        elasticsearchApi.getData(matchQueryBuilder);
    }
    @Test
    public void es_test6() {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("address", "六区");
        // QueryBuilders.multiMatchQuery()
        elasticsearchApi.getData(matchQueryBuilder);
    }
    @Test
    public void es_test7() {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("address", "宋泽家园");
        // QueryBuilders.multiMatchQuery()
        elasticsearchApi.getData(termQueryBuilder);
    }
    @Test
    public void es_test8() {
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("王五", "address", "name");
        // QueryBuilders.multiMatchQuery()
        elasticsearchApi.getData(multiMatchQueryBuilder);
    }
}
