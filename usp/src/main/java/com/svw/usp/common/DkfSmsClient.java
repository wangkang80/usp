/**
 * DfkSmsClient.java
 * Created at 2014-03-07
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.common;

import java.util.Iterator;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

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
     * Field nameSpace: 名称空间
     * </p>
     */
    private final static String NAME_SPACE = "http://api.webservice.sms.dkf.com/";

    /**
     * <p>
     * Field SEND_SMS_ONE_TO_MAY: 群发短信
     * </p>
     */
    private final static String SEND_SMS_ONE_TO_MAY = "sendsmsonetomay";

    /**
     * <p>
     * Field GET_USER_SMS_COUNT: 返回账号剩余短信条数
     * </p>
     */
    private final static String GET_USER_SMS_COUNT = "getUserSmsCount";

    /**
     * <p>
     * Field service: 服务
     * </p>
     */
    private ServiceClient service;

    /**
     * <p>
     * Field fac: 节点操作工厂
     * </p>
     */
    private OMFactory fac;

    /**
     * <p>
     * Field dkfWebserviceUserName: 用户名
     * </p>
     */
    public String dkfWebserviceUserName;

    /**
     * <p>
     * Field dkfWebservicePassword: 密码
     * </p>
     */
    public String dkfWebservicePassword;

    /**
     * <p>
     * Field dkfWebserviceSecretKey: 秘钥
     * </p>
     */
    public String dkfWebserviceSecretKey;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     * 
     * @param url 地址
     * @param dkfWebserviceUserName 用户名
     * @param dkfWebservicePassword 密码
     * @param dkfWebserviceSecretKey 秘钥
     * @throws AxisFault 异常
     */
    public DkfSmsClient(String url, String dkfWebserviceUserName, String dkfWebservicePassword,
            String dkfWebserviceSecretKey) throws AxisFault {
        this.service = new ServiceClient();
        Options options = this.service.getOptions();
        EndpointReference targetEpr = new EndpointReference(url);
        options.setTo(targetEpr);
        this.fac = OMAbstractFactory.getOMFactory();
        this.dkfWebserviceUserName = dkfWebserviceUserName;
        this.dkfWebservicePassword = dkfWebservicePassword;
        this.dkfWebserviceSecretKey = dkfWebserviceSecretKey;
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
     * @throws AxisFault 异常
     */
    @SuppressWarnings("rawtypes")
    public String sendSms(String user, String password, String[] mobiles, String content, String planTime,
            String filename) throws AxisFault {

        //设置方法和名称空间
        OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, "");
        OMElement call = fac.createOMElement(SEND_SMS_ONE_TO_MAY, omNs);

        //拼接参数
        OMElement arg0 = fac.createOMElement("arg0", "", "");
        arg0.setText(user);
        call.addChild(arg0);

        OMElement arg1 = fac.createOMElement("arg1", "", "");
        arg1.setText(password);
        call.addChild(arg1);

        for (String item : mobiles) {
            OMElement arg2 = fac.createOMElement("arg2", "", "");
            arg2.setText(item);
            call.addChild(arg2);
        }

        OMElement arg3 = fac.createOMElement("arg3", "", "");
        arg3.setText(content);
        call.addChild(arg3);

        OMElement arg4 = fac.createOMElement("arg4", "", "");
        arg4.setText(planTime);
        call.addChild(arg4);

        OMElement arg5 = fac.createOMElement("arg5", "", "");
        arg5.setText(filename);
        call.addChild(arg5);

        //发送
        String result = null;
        OMElement rv = this.service.sendReceive(call);
        Iterator it = rv.getChildElements();
        while (it.hasNext()) {
            OMElement el = (OMElement) it.next();
            if ("return".equals(el.getLocalName())) {
                result = el.getText();
                break;
            }
        }
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
     * @throws AxisFault 异常
     */
    @SuppressWarnings("rawtypes")
    public String getUserSmsCount(String user, String password) throws AxisFault {

        //设置方法和名称空间
        OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, "");
        OMElement call = fac.createOMElement(GET_USER_SMS_COUNT, omNs);

        //拼接参数
        OMElement arg0 = fac.createOMElement("arg0", "", "");
        arg0.setText(user);
        call.addChild(arg0);

        OMElement arg1 = fac.createOMElement("arg1", "", "");
        arg1.setText(password);
        call.addChild(arg1);

        //发送
        String result = null;
        OMElement rv = this.service.sendReceive(call);
        Iterator it = rv.getChildElements();
        while (it.hasNext()) {
            OMElement el = (OMElement) it.next();
            if ("return".equals(el.getLocalName())) {
                result = el.getText();
                break;
            }
        }
        return result;
    }

    //    public static void main(String[] args) throws Exception {
    //        try {
    //
    //            String user = DesTools.encrypt("1", "1");
    //            String password = DesTools.encrypt("1", "1");
    //            System.out.println(user + "," + password);
    //
    //            String mobile = null;
    //            String content = null;
    //            String mobiles[] = null;
    //
    //            DkfSmsClient c = new DkfSmsClient("http://127.0.0.1:8080/CXFWebservice/DKFServices?wsdl");
    //
    //            mobile = DesTools.encrypt("1", "1");
    //            content = DesTools.encrypt("测试短信5", "1");
    //            mobiles = new String[] { mobile };
    //            String result = c.sendSms(user, password, mobiles, content, null, null);
    //            System.out.println("result=" + result);
    //
    //            //String result = c.getUserSmsCount(user, password);
    //            //System.out.println("result=" + result);
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }
}
