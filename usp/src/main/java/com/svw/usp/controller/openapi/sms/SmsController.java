/**
 * SmsController.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.controller.openapi.sms;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.llsfw.core.common.Constants;
import com.llsfw.core.controller.base.BaseController;
import com.svw.usp.common.DesTools;
import com.svw.usp.model.expand.RequestSendSmsVo;
import com.svw.usp.model.expand.ResponseSendSmsVo;
import com.svw.usp.model.standard.TuUser;
import com.svw.usp.service.MainPageService;
import com.svw.usp.service.openapi.sms.SmsServices;

/**
 * <p>
 * ClassName: SmsController
 * </p>
 * <p>
 * Description: 短信接口
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
@Controller("openSmsController")
@RequestMapping("/openapi/sms")
public class SmsController extends BaseController {

    /**
     * <p>
     * Field ss: 短信发送服务
     * </p>
     */
    @Autowired
    private SmsServices ss;

    /**
     * <p>
     * Field mps: 主页dao
     * </p>
     */
    @Autowired
    private MainPageService mps;

    /**
     * <p>
     * Description: 发送SMS短消息
     * </p>
     * 
     * @param httpServletRequest 请求对象
     * @return 响应对象
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public ResponseSendSmsVo send(HttpServletRequest httpServletRequest) {

        //设定返回值
        ResponseSendSmsVo responseSendSmsVo = null;

        //开始处理
        try {

            //记录消息接受时间
            Date receiveDate = new Date();

            //获得头信息中的用户名
            String userName = httpServletRequest.getHeader(com.svw.usp.common.Constants.HTTP_REQUEST_HEADER_USERNAME);

            //获得用户秘钥
            TuUser user = this.mps.loadTuUser(userName);

            //获得请求数据
            String requestData = null;
            try {
                requestData = Constants.getData(httpServletRequest.getInputStream());
            } catch (Throwable ex) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_11);
                throw new Exception("获取消息体有误");
            }

            //判断是否有数据
            if (StringUtils.isEmpty(requestData)) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_4);
                throw new Exception("请求消息体为空");
            }

            //消息体解密
            try {
                requestData = DesTools.decrypt(requestData, user.getInterfaceSecretKey());
            } catch (Throwable ex) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_10);
                throw new Exception("消息体解密有误");
            }

            //json转换
            RequestSendSmsVo requestSendSmsVo = null;
            try {
                requestSendSmsVo = JSON.parseObject(requestData, new TypeReference<RequestSendSmsVo>() {
                });
            } catch (Throwable ex) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_5);
                throw new Exception("请求消息体有误");
            }

            //判断是否存在号码列表
            if (CollectionUtils.isEmpty(requestSendSmsVo.getMobiles())) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_6);
                throw new Exception("号码列表为空");
            }

            //验证手机号码的正确性(列表中有一个有问题,则退回)
            for (String m : requestSendSmsVo.getMobiles()) {
                boolean rv = com.svw.usp.common.Constants.isMobileNO(m);
                if (!rv) {
                    responseSendSmsVo = new ResponseSendSmsVo();
                    responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_12);
                    throw new Exception("包含错误的手机号码");
                }
            }

            //判断是否存在短信内容
            if (StringUtils.isEmpty(requestSendSmsVo.getContent())) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_7);
                throw new Exception("短信内容为空");
            }

            //如果有定时时间的话,判断时间格式
            if (!StringUtils.isEmpty(requestSendSmsVo.getPlanTime())) {
                try {
                    new SimpleDateFormat("yyyyMMddHHmm").parse(requestSendSmsVo.getPlanTime());
                } catch (Throwable ex) {
                    responseSendSmsVo = new ResponseSendSmsVo();
                    responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_8);
                    throw new Exception("定时时间格式有误");
                }
            }

            //判断是否有余额
            if (!ss.checkSmsCount(userName)) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_9);
                throw new Exception("短信余额不足,请充值");
            }

            //保存
            responseSendSmsVo = this.ss.sendSms(receiveDate, userName, requestSendSmsVo);

        } catch (Throwable e) {

            //如果响应值为空,则填入未知错误
            if (responseSendSmsVo == null) {
                responseSendSmsVo = new ResponseSendSmsVo();
                responseSendSmsVo.setResponseStatus(com.svw.usp.common.Constants.SEND_SMS_STATUS_99999999);
                this.log.error("未知错误:", e);
            } else {
                this.log.info("校验错误:", e);
            }

            //设置响应时间
            responseSendSmsVo.setResponseTime(new Date());
        }
        return responseSendSmsVo;
    }
}
