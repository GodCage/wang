//package com.wangkaiqi.wang.base.utils;
//
//import ch.ethz.ssh2.Connection;
//import ch.ethz.ssh2.Session;
//import ch.ethz.ssh2.StreamGobbler;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//
//import java.io.*;
//
//
//
//@Slf4j
//public class SshUtil {
//
//    /**
//     *
//     * 功能描述:
//
//     */
//    private static String processStdout(InputStream in, String charset){
//        InputStream stdout = new StreamGobbler(in);
//        StringBuffer buffer = new StringBuffer();;
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(stdout,charset));
//            String line=null;
//            while((line=br.readLine()) != null){
////                System.out.println(line);
//                buffer.append(line);
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return buffer.toString();
//    }
//
//    /**
//     *
//     * 功能描述: ssh执行命令
//     *
//     * @param:
//     * @return:
//     * @auther: Li Jun
//     * @date: 2018/7/9 14:57
//     */
//    public static String exeCmd(String hostname, String username, String password, String cmd)
//    {
//        String result="";
//        //指明连接主机的IP地址
//        Connection conn = new Connection(hostname);
//        Session ssh = null;
//        try {
//            //连接到主机
//            conn.connect();
//            //使用用户名和密码校验
//            boolean isconn = conn.authenticateWithPassword(username, password);
//            if(!isconn){
//                log.info(hostname+"->用户名称或者是密码不正确");
//            }else{
//                log.info("已经连接OK->"+hostname);
//                ssh = conn.openSession();
//                System.out.println("hostname:"+hostname+" cmd:"+cmd);
//                //使用多个命令用分号隔开
//                ssh.execCommand(cmd);
//                //只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常
//                result=processStdout(ssh.getStdout(),"utf-8");
//
//                //如果为得到标准输出为空，说明脚本执行出错了
//                if(StringUtils.isBlank(result)){
//                    result=processStdout(ssh.getStderr(),"utf-8");
//                }
//
//            }
//            //连接的Session和Connection对象都需要关闭
//            ssh.close();
//            conn.close();
//
//        } catch (IOException e) {
//            log.error("连接失败->"+hostname);
//        }
//        return result;
//    }
//
//    public  static void main(String a[]){
////        exeCmd("192.168.44.132","docker","docker","uname -r && who");
//
//        String md5Pwd = CommonUtil.getMD5("admin-123");
//        System.out.println(md5Pwd);
//    }
//}
