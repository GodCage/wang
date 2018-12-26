package com.wangkaiqi.wang.base.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * java调用系统命令工具类
 *
 * @author wangkaiqi
 */
@Slf4j
public class CmdUtil {

    /**
     * @param cmd: 需要执行的命令
     */
    public static String execCmd(String cmd){
        log.info("调用执行cmd指令 start..."+cmd);
        Runtime runtime=Runtime.getRuntime();
        if(CommonUtil.isWindows()){
            cmd = "cmd /c " +cmd;
        }else{
            cmd = "/bin/sh -c "+cmd;
        }
        StringBuilder output = new StringBuilder();
        try {
            Process proc = runtime.exec(cmd);
            InputStream stderr =  proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line="";
            while ((line = br.readLine()) != null) {
                // 打印出命令执行的结果
                output.append(line);
                log.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            output.append("CMD ERROR");
        } catch (Exception e){
            e.printStackTrace();
            output.append("CMD ERROR");
        }
        log.info("调用执行cmd指令 end...");

        return output.toString();
    }

}
