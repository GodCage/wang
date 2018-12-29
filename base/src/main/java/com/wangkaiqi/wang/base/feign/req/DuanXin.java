package com.wangkaiqi.wang.base.feign.req;

import lombok.Data;

/**
 * @author wangkaiqi
 * @date Created in 2018/12/29 14:16
 */
@Data
public class DuanXin {
    /*  //接受短信的用户手机号码
        jsonObject.put("mobile","18816271671");
        //您申请的短信模板ID，根据实际情况修改
        jsonObject.put("tpl_id","126383");
        //您设置的模板变量，根据实际情况修改
        jsonObject.put("tpl_value","#code#=1314520");
        //应用APPKEY(应用详细页查询)
        jsonObject.put("key","b14b5b5434306691937d30cc264adc3a");
    */
    
    private String  mobile = "18816271671";
    private String  tpl_id = "126383";
    private String  tpl_value = "#code#=1314520";
    private String  key = "b14b5b5434306691937d30cc264adc3a";
}
