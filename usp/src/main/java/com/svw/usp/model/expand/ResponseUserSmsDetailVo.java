/**
 * ResponseSendSmsVo.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.model.expand;

import com.svw.usp.model.standard.TuSmsArchive;

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
public class ResponseUserSmsDetailVo extends ResponseVo {

    /**
     * <p>
     * Field smsDetail: 消息明细
     * </p>
     */
    TuSmsArchive smsDetail;

    public TuSmsArchive getSmsDetail() {
        return smsDetail;
    }

    public void setSmsDetail(TuSmsArchive smsDetail) {
        this.smsDetail = smsDetail;
    }

}
