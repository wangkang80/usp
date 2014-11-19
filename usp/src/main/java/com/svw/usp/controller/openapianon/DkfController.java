/**
 * DkfController.java
 * Created at 2014年11月19日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.controller.openapianon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llsfw.core.controller.base.BaseController;

/**
 * <p>
 * ClassName: DkfController
 * </p>
 * <p>
 * Description: 接收上行短信
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月19日
 * </p>
 */
@Controller("dkfController")
@RequestMapping("/openapianon/dkf")
public class DkfController extends BaseController {

    /**
     * <p>
     * Description: 接收上行短信
     * </p>
     * 
     * @param receiver 用户名
     * @param receiver 用户名
     * @param pswd 密码
     * @param mobile 电话
     * @param content 内容
     * @param motime 时间
     * @return 状态码
     */
    @RequestMapping("receive/{channelcode}")
    @ResponseBody
    public String receive(@PathVariable String channelcode, String receiver, String pswd, String mobile,
            String content, String motime) {
        this.log.info("channelcode:" + channelcode);
        this.log.info("receiver:" + receiver);
        this.log.info("pswd:" + pswd);
        this.log.info("mobile:" + mobile);
        this.log.info("content:" + content);
        this.log.info("motime:" + motime);
        return "200k";
    }
}
