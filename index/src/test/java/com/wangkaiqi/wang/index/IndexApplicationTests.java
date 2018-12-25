package com.wangkaiqi.wang.index;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexApplicationTests {

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
    
    public static void main(String[] args) {
       new  IndexApplicationTests().test2();
    }
    
}

