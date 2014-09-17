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
     * Field MAX_SEND_SMS_CONTENT_LENGTH: 发送消息最大长度,超过此长度,拆分多条消息
     * </p>
     */
    MAX_SEND_SMS_CONTENT_LENGTH, /**
     * <p>
     * Field SMS_SEND_TABLE_COUNT: 发送表的个数
     * </p>
     */
    SMS_SEND_TABLE_COUNT, /**
     * <p>
     * Field SMS_BILLING_TABLE_COUNT: 计费表的个数
     * </p>
     */
    SMS_BILLING_TABLE_COUNT
}
