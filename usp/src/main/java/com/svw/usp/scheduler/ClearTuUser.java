/**
 * ClearTuUser.java
 * Created at 2014年10月9日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.scheduler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.llsfw.core.scheduler.AbstractBaseJob;
import com.svw.usp.service.scheduler.ISmsServices;

/**
 * <p>
 * ClassName: ClearTuUser
 * </p>
 * <p>
 * Description: 清除用户扩展表中的多余数据
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年10月9日
 * </p>
 */
@DisallowConcurrentExecution
public class ClearTuUser extends AbstractBaseJob {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //调用业务服务
        ISmsServices iss = null;
        iss = this.getApplicationContext().getBean("schSmsService", ISmsServices.class);
        iss.clearTuUser();
    }

}
