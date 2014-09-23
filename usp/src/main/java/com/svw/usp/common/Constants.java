/**
 * Constants.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * ClassName: Constants
 * </p>
 * <p>
 * Description: 常量定义
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
public class Constants {

    /**
     * <p>
     * Field HTTP_REQUEST_HEADER_USERNAME: TODO
     * </p>
     */
    public static final String HTTP_REQUEST_HEADER_USERNAME = "userName";
    /**
     * <p>
     * Field HTTP_REQUEST_HEADER_PASSWORD: TODO
     * </p>
     */
    public static final String HTTP_REQUEST_HEADER_PASSWORD = "password";

    //------------------------------------

    /**
     * <p>
     * Field STATUS_0: 状态0
     * </p>
     */
    public static final String STATUS_0 = "0";

    /**
     * <p>
     * Field STATUS_1: 状态1
     * </p>
     */
    public static final String STATUS_1 = "1";

    /**
     * <p>
     * Field STATUS_2: 状态2
     * </p>
     */
    public static final String STATUS_2 = "2";

    //------------------------------------

    /**
     * <p>
     * Field SEND_SMS_STATUS_99999999: 未知错误
     * </p>
     */
    public static final String SEND_SMS_STATUS_99999999 = "99999999";

    /**
     * <p>
     * Field SEND_SMS_STATUS_0: 发送成功
     * </p>
     */
    public static final String SEND_SMS_STATUS_0 = "0";

    /**
     * <p>
     * Field SEND_SMS_STATUS_1: 用户名或者密码为空
     * </p>
     */
    public static final String SEND_SMS_STATUS_1 = "1";

    /**
     * <p>
     * Field SEND_SMS_STATUS_2: 用户不存在或者未激活
     * </p>
     */
    public static final String SEND_SMS_STATUS_2 = "2";

    /**
     * <p>
     * Field SEND_SMS_STATUS_3: 用户名或者密码错误(密码错误)
     * </p>
     */
    public static final String SEND_SMS_STATUS_3 = "3";

    /**
     * <p>
     * Field SEND_SMS_STATUS_4: 请求消息体为空
     * </p>
     */
    public static final String SEND_SMS_STATUS_4 = "4";

    /**
     * <p>
     * Field SEND_SMS_STATUS_5: 请求消息体有误
     * </p>
     */
    public static final String SEND_SMS_STATUS_5 = "5";

    /**
     * <p>
     * Field SEND_SMS_STATUS_6: 号码列表为空
     * </p>
     */
    public static final String SEND_SMS_STATUS_6 = "6";

    /**
     * <p>
     * Field SEND_SMS_STATUS_7: 短信内容为空
     * </p>
     */
    public static final String SEND_SMS_STATUS_7 = "7";

    /**
     * <p>
     * Field SEND_SMS_STATUS_8: 定时时间格式有误
     * </p>
     */
    public static final String SEND_SMS_STATUS_8 = "8";

    /**
     * <p>
     * Field SEND_SMS_STATUS_9: 短信余额不足,请充值
     * </p>
     */
    public static final String SEND_SMS_STATUS_9 = "9";

    /**
     * <p>
     * Field SEND_SMS_STATUS_10: 消息体解密有误
     * </p>
     */
    public static final String SEND_SMS_STATUS_10 = "10";

    /**
     * <p>
     * Field SEND_SMS_STATUS_11: 获取消息体有误
     * </p>
     */
    public static final String SEND_SMS_STATUS_11 = "11";

    /**
     * <p>
     * Field SEND_SMS_STATUS_12: 包含有错误的手机号码
     * </p>
     */
    public static final String SEND_SMS_STATUS_12 = "12";

    //--------------------------------------------

    /**
     * <p>
     * Description: 验证手机号码的正确性
     * </p>
     * 
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
