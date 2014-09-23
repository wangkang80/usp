/**
 * RequestSendSmsVo.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.model.expand;

import java.util.List;

/**
 * <p>
 * ClassName: RequestSendSmsVo
 * </p>
 * <p>
 * Description: 发送短消息请求对象
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
public class RequestSendSmsVo {
    /**
     * <p>
     * Field mobiles: 号码列表,最大100个
     * </p>
     */
    private List<String> mobiles;

    /**
     * <p>
     * Field content: 消息内容,最大长度250,超出则拆分成两条数据,每条数据计费单位50个字符
     * </p>
     */
    private String content;
    /**
     * <p>
     * Field planTime: 定时发送时间,格式yyyyMMddHHmm
     * </p>
     */
    private String planTime;
    /**
     * <p>
     * Field priority: 优先级,0为优先级最高,默认为5
     * </p>
     */
    private String priority;

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
