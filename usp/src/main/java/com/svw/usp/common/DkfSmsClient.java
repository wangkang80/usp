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

    //    public static void main(String[] args) {
    //        String mobile;
    //        try {
    //            mobile = DesTools.encrypt("15221143497", "12345678abcdefghABCDEFGH");
    //            String user = DesTools.encrypt("12801", "12345678abcdefghABCDEFGH");
    //            String password = DesTools.encrypt("2W2i6o11", "12345678abcdefghABCDEFGH");
    //            String content = DesTools.encrypt("测试短信1", "12345678abcdefghABCDEFGH");
    //            String mobiles[] = new String[] { mobile };
    //            DkfSmsClient clientDemo = new DkfSmsClient();
    //            //String result = clientDemo.sendSms(user, password, mobiles, content, "", "");
    //            String result = clientDemo.getUserSmsCount(user, password);
    //            System1.out.println("result=" + result);
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //
    //    }
}
