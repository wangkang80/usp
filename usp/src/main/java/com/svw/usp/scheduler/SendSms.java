/**
 * SendSms.java
 * Created at 2014年9月24日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.scheduler;

import org.apache.commons.lang3.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.llsfw.core.scheduler.AbstractBaseJob;
import com.svw.usp.service.scheduler.ISmsServices;

/**
 * <p>
 * ClassName: SendSms
 * </p>
 * <p>
 * Description: 发送sms消息
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月24日
 * </p>
 */
@DisallowConcurrentExecution
public class SendSms extends AbstractBaseJob {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {

            //获得jobMap中配置的表名称
            String tableName = jobExecutionContext.getJobDetail().getJobDataMap().getString("TABLE_NAME");

            //如果没有配置,则直接抛错
            if (StringUtils.isEmpty(tableName)) {
                throw new Exception("缺少必要的jobDataMap:[TABLE_NAME]");
            }

            //调用业务服务
            ISmsServices iss = null;
            iss = this.getApplicationContext().getBean("schSmsService", ISmsServices.class);
            iss.sendSms(tableName);

            //是否还有剩余业务数据未处理,如果有,则直接触发下一次执行
            iss.fastTriggerSend(jobExecutionContext.getJobDetail().getKey(), tableName);

        } catch (Throwable e) {
            throw new JobExecutionException(e);
        }
    }

}
