/**
 * ISmsServices.java
 * Created at 2014年9月24日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.scheduler;

import org.quartz.JobKey;

/**
 * <p>
 * ClassName: ISmsServices
 * </p>
 * <p>
 * Description: sms消息计划任务接口
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月24日
 * </p>
 */
public interface ISmsServices {

    /**
     * <p>
     * Description: 结算sms消息
     * </p>
     * 
     * @param tableName
     * @throws Exception
     */
    public void billingSms(String tableName) throws Exception;

    /**
     * <p>
     * Description: 发送SMS消息
     * </p>
     * 
     * @param tableName 表名
     * @throws Exception 异常
     */
    public void sendSms(String tableName) throws Exception;

    /**
     * <p>
     * Description: 快速触发下一次执行
     * </p>
     * 
     * @param key job签名
     * @param tableName 表名
     * @throws Exception 异常
     */
    public void fastTriggerSend(JobKey key, String tableName) throws Exception;

    /**
     * <p>
     * Description: 快速触发下一次执行
     * </p>
     * 
     * @param key job签名
     * @param tableName 表名
     * @throws Exception 异常
     */
    public void fastTriggerBilling(JobKey key, String tableName) throws Exception;

    /**
     * <p>
     * Description: 清理无用的用户扩展表信息
     * </p>
     */
    public void clearTuUser();
}
