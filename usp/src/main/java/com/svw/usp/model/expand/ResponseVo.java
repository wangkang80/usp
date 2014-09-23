/**
 * ResponseVo.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.model.expand;

import java.util.Date;

/**
 * <p>
 * ClassName: ResponseVo
 * </p>
 * <p>
 * Description: 响应对象
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
public class ResponseVo {
    /**
     * <p>
     * Field responseStatus: 响应状态,状态解释请见文档
     * </p>
     */
    private String responseStatus;
    /**
     * <p>
     * Field responseTime: 响应时间
     * </p>
     */
    private Date responseTime;

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }
}
