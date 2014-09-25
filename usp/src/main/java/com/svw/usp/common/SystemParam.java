/**
 * SystemParamEnum.java
 * Created at 2014-03-07
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.common;

/**
 * <p>
 * ClassName: SYSTEM_PARAM_ENUM
 * </p>
 * <p>
 * Description: 系统参数枚举
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年3月7日
 * </p>
 */
public enum SystemParam {
    /**
     * <p>
     * Field SEND_REAL: 是否真实发送,0:假发送,1:真发送
     * </p>
     */
    SEND_REAL,
    /**
     * <p>
     * Field SINGLE_SMS_CONTENT_LENGTH: 单条消息最大长度(计费单位=1),超过此长度,则为长短信(计费单位>1)
     * </p>
     */
    SINGLE_SMS_CONTENT_LENGTH,
    /**
     * <p>
     * Field MAX_SMS_CONTENT_LENGTH: 发送消息最大长度,超过此长度,拆分多条消息
     * </p>
     */
    MAX_SMS_CONTENT_LENGTH, /**
     * <p>
     * Field MAX_MOBILE_LIST: 号码列表最大长度,超出此长度,则拆分成多条消息
     * </p>
     */
    MAX_MOBILE_LIST, /**
     * <p>
     * Field SMS_SEND_TABLE_COUNT: 发送表的个数
     * </p>
     */
    SMS_SEND_TABLE_COUNT, /**
     * <p>
     * Field SMS_BILLING_TABLE_COUNT: 计费表的个数
     * </p>
     */
    SMS_BILLING_TABLE_COUNT, /**
     * <p>
     * Field DKF_WEBSERVICE_URL: 电科发服务地址
     * </p>
     */
    DKF_WEBSERVICE_URL, /**
     * <p>
     * Field DKF_WEBSERVICE_USERNAME: 电科发服务用户名
     * </p>
     */
    DKF_WEBSERVICE_USERNAME, /**
     * <p>
     * Field DKF_WEBSERVICE_PASSWORD: 电科发服务密码
     * </p>
     */
    DKF_WEBSERVICE_PASSWORD, /**
     * <p>
     * Field DKF_WEBSERVICE_SECRET_KEY: 电科发服务秘钥
     * </p>
     */
    DKF_WEBSERVICE_SECRET_KEY, /**
     * <p>
     * Field SEND_SMS_MAX_EXEC_COUNT: 单次发送消息的条数
     * </p>
     */
    SEND_SMS_MAX_EXEC_COUNT, /**
     * <p>
     * Field SEND_REAL_SLEEP_TIME: 假发送,线程休眠的时间(毫秒)
     * </p>
     */
    SEND_REAL_SLEEP_TIME, /**
     * <p>
     * Field SEND_SMS_MAX_BILLING_COUNT: 单次单用户结算消息的条数
     * </p>
     */
    SEND_SMS_MAX_BILLING_COUNT
}
