package com.wangkaiqi.wang.base.service;

import com.wangkaiqi.wang.base.feign.BaseFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangkaiqi
 * @date Created in 2018/12/29 13:19
 */
@Service
public class BaseService {
    @Autowired
    BaseFeign baseFeign;
    
}
