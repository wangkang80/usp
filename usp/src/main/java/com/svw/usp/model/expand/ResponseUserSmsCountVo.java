/**
 * ResponseSendSmsVo.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.model.expand;

/**
 * <p>
 * ClassName: ResponseSendSmsVo
 * </p>
 * <p>
 * Description: 查询剩余消息条数响应对象
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
public class ResponseUserSmsCountVo extends ResponseVo {

    /**
     * <p>
     * Field lastSmsCount: 消息条数
     * </p>
     */
    private int lastSmsCount;

    public int getLastSmsCount() {
        return lastSmsCount;
    }

    public void setLastSmsCount(int lastSmsCount) {
        this.lastSmsCount = lastSmsCount;
    }

}
