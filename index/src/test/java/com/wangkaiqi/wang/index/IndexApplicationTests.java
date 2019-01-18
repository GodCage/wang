package com.wangkaiqi.wang.index;

import com.wangkaiqi.wang.index.elasticsearch.ElasticsearchApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class IndexApplicationTests {

    @Autowired
    ElasticsearchApi elasticsearchApi;
    @Test
    public void contextLoads() {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24);
        int rawOffset = TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        zero-=rawOffset;
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
        System.out.println(new Date(current));//当前时间
        System.out.println(new Date(yesterday));//昨天这一时间点
        System.out.println(new Date(zero));//今天零点零分零秒
        System.out.println(new Date(twelve));//今天23点59分59秒
    }
    @Test
    public void test2() {
       String a="   ";
        System.out.println(a=="   ");
        System.out.println(a.trim().equals(""));
        System.out.println(a);
    }
    @Test
    public void es_test2() {
        Map<String,Object> persion = new HashMap<>();
        Map<String,Object> car = new HashMap<>();
        List<Map<String,Object>> cars = new ArrayList<>();
        car.put("pic","http://");
        car.put("color","yellow");
        car.put("tollNo","苏E12323");
        cars.add(car);
        
        persion.put("name","李四");
        persion.put("age",30);
        persion.put("qq","18654564");
        persion.put("address","宋泽家园");
        persion.put("cars",cars);
        
        elasticsearchApi.setData(persion);
    }
    @Test
    public void es_test3() {
        elasticsearchApi.getData();
    }
    
    
    public static void main(String[] args) {
       new  IndexApplicationTests().test2();
    }
    
}

