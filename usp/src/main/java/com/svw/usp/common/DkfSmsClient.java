/**
 * DfkSmsClient.java
 * Created at 2014-03-07
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.common;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * <p>
 * ClassName: DfkSmsClient
 * </p>
 * <p>
 * Description: 电科发短信客户端
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月12日
 * </p>
 */
public class DkfSmsClient {

    /**
     * <p>
     * Field SERVICE_ENDPOINT: webservice地址
     * </p>
     */
    private static final String SERVICE_ENDPOINT = "http://61.129.70.81:8689/GeneralWs/services/DkfServices?wsdl";

    /**
     * <p>
     * Description: 短信发送
     * </p>
     * 
     * @param user 用户名
     * @param password 密码
     * @param mobiles 电话
     * @param content 内容
     * @param planTime 计划时间
     * @param filename 文件名
     * @return 状态
     * @throws ServiceException 创建服务异常
     * @throws MalformedURLException 解析url异常
     * @throws RemoteException 远程调用异常
     */
    public String sendSms(String user, String password, String[] mobiles, String content, String planTime,
            String filename) throws ServiceException, MalformedURLException, RemoteException {

        Service service = null;
        service = new Service();

        Call call = null;
        call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(SERVICE_ENDPOINT));
        call.setOperationName(new QName("SendSMS"));

        String result = null;
        result = (String.valueOf((call.invoke(new Object[] { user, password, mobiles, content, planTime, filename }))));

        return result;
    }

    /**
     * <p>
     * Description: 查询SMS的数量
     * </p>
     * 
     * @param user 用户名
     * @param password 密码
     * @return 结果
     * @throws ServiceException 创建服务异常
     * @throws MalformedURLException 解析url异常
     * @throws RemoteException 远程调用异常
     */
    public String getUserSmsCount(String user, String password) throws ServiceException, MalformedURLException,
            RemoteException {

        Service service = null;
        service = new Service();

        Call call = null;
        call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(SERVICE_ENDPOINT));
        call.setOperationName(new QName("getUserSmsCount"));

        String result = null;
        result = (String.valueOf((call.invoke(new Object[] { user, password }))));

        return result;
    }

    //    public static void main(String[] arge) {
    //        Map<Long, Long> count = new HashMap<Long, Long>();
    //        count.put(0l, 0l);
    //        count.put(1l, 0l);
    //        count.put(2l, 0l);
    //        count.put(3l, 0l);
    //        count.put(4l, 0l);
    //        count.put(5l, 0l);
    //        count.put(6l, 0l);
    //        count.put(7l, 0l);
    //        count.put(8l, 0l);
    //        count.put(9l, 0l);
    //        for (int i = 0; i <= 1000000; i++) {
    //            long a = System.currentTimeMillis() % 2;
    //            count.put(a, count.get(a) + 1);
    //        }
    //        System1.out.println(count);
    //    }

    public static void main(String[] args) throws Exception {
        String mobile;
        try {
            mobile = DesTools.encrypt("15221143497", "C9eLew123456");
            String user = DesTools.encrypt("12801", "C9eLew123456");
            String password = DesTools.encrypt("2W2i6o", "C9eLew123456");
            String content = DesTools.encrypt("测试短信1", "C9eLew123456");
            String mobiles[] = new String[] { mobile };
            DkfSmsClient clientDemo = new DkfSmsClient();
            String result = clientDemo.sendSms(user, password, mobiles, content, "", "");
            //String result = clientDemo.getUserSmsCount(user, password);
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
