package com.wangkaiqi.wang.base.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author wangkaiqi
 * @date 2018-12-5
 */
@FeignClient(name = "disposition", url = "${feign.traffic.url}")
public interface BaseFeign {
    /**
     * Feign发送反馈报警信息
     * @param alarmFeedbackReq 反馈信息实体
     * @return 返回结果  FeignTestResp 对象
     */
    @GetMapping(value="/alarm/handle/feedback")
    JSONObject postAlarmFeedback(String alarmFeedbackReq);

}


