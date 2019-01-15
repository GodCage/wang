package com.wangkaiqi.wang.index.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangkaiqi
 * @date Created in 2019/1/3 13:46
 */
@Slf4j
public class IpUtil {
    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request HttpServletRequest
     * @return ip
     */
    public static String getRemoteIp(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String unKnown = "unknown";
        int ipLength = 15;
        String ip = request.getHeader("X-Forwarded-For");
        if (ip!=null) {
            log.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }
        if (ip == null || ip.length() == 0 || unKnown.equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || unKnown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (ip!=null) {
                    log.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unKnown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (ip!=null) {
                    log.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unKnown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (ip!=null) {
                    log.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unKnown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (ip!=null) {
                    log.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unKnown.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (ip!=null) {
                    log.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        }else if (ip.length() > ipLength) {
            String[] ips = ip.split(",");
            for (String strIp : ips) {
                if (!(unKnown.equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
    

