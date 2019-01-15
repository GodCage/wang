package com.wangkaiqi.wang.base.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author wangkaiqi
 * @date 2018-12-5
 */
@Component
@FeignClient(url = "http://v.juhe.cn",name = "test")
public interface BaseFeign {
    /**
     * Feign发送短信验证码
     * @param jsonObject 反馈信息实体
     * @return 返回结果  JSONObject 对象
     */
    @GetMapping(value="/sms/send")
    JSONObject sendMessage(@RequestParam JSONObject jsonObject);
}


