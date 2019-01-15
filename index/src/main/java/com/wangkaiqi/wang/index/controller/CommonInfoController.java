package com.wangkaiqi.wang.index.controller;

import com.alibaba.fastjson.JSONObject;
import com.wangkaiqi.wang.index.util.IpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共信息
 *
 * @author wangkaiqi
 * @date Created in 2019/1/3 14:53
 */
@Api(tags = "CommonInfoController", description = "公共信息")
@Slf4j
@RestController
@RequestMapping("/common/info")
public class CommonInfoController {
    @Resource(name = "myKafkaTemplate")
    KafkaTemplate<String, String> myKafkaTemplate;
    
    @ApiOperation(value = "客户端ip查询")
    @GetMapping("/ip")
    public Object getRemoteIp(@ApiParam HttpServletRequest request) {
        return IpUtil.getRemoteIp(request);
    }
    
    @ApiOperation(value = "发送kafka消息")
    @GetMapping("/kafka")
    public Object sendKafkaMessage() {
        Map<String,String> map=new HashMap(2);
       map.put("test","test");
        myKafkaTemplate.send("test_test", "test", JSONObject.toJSONString(map));
        return map;
    }
}
