/**
 * ResponseSendSmsVo.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.model.expand;

import java.util.List;

/**
 * <p>
 * ClassName: ResponseSendSmsVo
 * </p>
 * <p>
 * Description: 发送短消息响应对象
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
public class ResponseSendSmsVo extends ResponseVo {

    /**
     * <p>
     * Field msgId: 消息ID
     * </p>
     */
    private List<String> msgId;

    public List<String> getMsgId() {
        return msgId;
    }

    public void setMsgId(List<String> msgId) {
        this.msgId = msgId;
    }

}
