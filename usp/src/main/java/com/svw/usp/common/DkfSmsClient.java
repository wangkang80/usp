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
     * Field service: 服务
     * </p>
     */
    private Service service;

    /**
     * <p>
     * Field call: 创建call
     * </p>
     */
    private Call call;

    /**
     * <p>
     * Field url: 地址
     * </p>
     */
    private String url;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     * 
     * @param url 地址
     */
    public DkfSmsClient(String url) {
        this.service = new Service();
        this.url = url;
    }

    /**
     * <p>
     * Description: 创建call
     * </p>
     * 
     * @param qName 方法名称
     * @throws ServiceException 服务异常
     * @throws MalformedURLException 解析url异常
     */
    public void createCall(String qName) throws ServiceException, MalformedURLException {
        this.call = (Call) this.service.createCall();
        this.call.setTargetEndpointAddress(new java.net.URL(url));
        this.call.setOperationName(new QName(qName));
    }

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
     * @throws RemoteException 远程调用异常
     */
    public String sendSms(String user, String password, String[] mobiles, String content, String planTime,
            String filename) throws RemoteException {

        //调用
        String result = null;
        result = (String.valueOf((this.call
                .invoke(new Object[] { user, password, mobiles, content, planTime, filename }))));

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
     * @throws RemoteException 远程调用异常
     */
    public String getUserSmsCount(String user, String password) throws RemoteException {

        String result = null;
        result = (String.valueOf((call.invoke(new Object[] { user, password }))));

        return result;
    }

    //    public static void main(String[] args) throws Exception {
    //        String mobile;
    //        try {
    //            mobile = DesTools.encrypt("15221143497", "C9eLew123456");
    //            String user = DesTools.encrypt("12801", "C9eLew123456");
    //            String password = DesTools.encrypt("2W2i6o", "C9eLew123456");
    //            String content = DesTools.encrypt("测试短信1", "C9eLew123456");
    //            System.out.println(user + "," + password);
    //            //String mobiles[] = new String[] { mobile };
    //            //DkfSmsClient clientDemo = new DkfSmsClient();
    //            //String result = clientDemo.sendSms(user, password, mobiles, content, "", "");
    //            //String result = clientDemo.getUserSmsCount(user, password);
    //            //System.out.println("result=" + result);
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }
}
