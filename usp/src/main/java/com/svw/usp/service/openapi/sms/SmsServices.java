/**
 * SmsServices.java
 * Created at 2014年9月23日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.openapi.sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llsfw.core.common.UUID;
import com.llsfw.core.service.BaseService;
import com.svw.usp.common.Constants;
import com.svw.usp.common.SystemParam;
import com.svw.usp.mapper.expand.TuSmsSendMapper;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.model.expand.RequestSendSmsVo;
import com.svw.usp.model.expand.ResponseSendSmsVo;
import com.svw.usp.model.expand.TuSmsSend;

/**
 * <p>
 * ClassName: SmsServices
 * </p>
 * <p>
 * Description: 短信服务
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月23日
 * </p>
 */
@Service
public class SmsServices extends BaseService {

    /**
     * <p>
     * Field tu: 用户扩展dao
     * </p>
     */
    @Autowired
    private TuUserMapper tu;

    @Autowired
    private TuSmsSendMapper tssm;

    public ResponseSendSmsVo sendSms(Date receiveDate, String userName, RequestSendSmsVo requestSendSmsVo) {

        //返回值
        ResponseSendSmsVo rv = new ResponseSendSmsVo();
        List<String> msgIdList = new ArrayList<String>();

        //获取必要参数
        int singleSmsContentLength = Integer.parseInt(this.getPs().getServerParamter(
                SystemParam.SINGLE_SMS_CONTENT_LENGTH.name()));
        int smsSendTableCount = Integer.parseInt(this.getPs()
                .getServerParamter(SystemParam.SMS_SEND_TABLE_COUNT.name()));

        //拆分消息
        List<RequestSendSmsVo> vos = this.smsSplit(requestSendSmsVo);

        //循环保存
        for (RequestSendSmsVo item : vos) {

            //计算短消息内容计费单位
            int counta = item.getContent().length() / singleSmsContentLength;
            int countb = item.getContent().length() % singleSmsContentLength == 0 ? 0 : 1;
            int splitCount = counta + countb;

            //获得uuid
            String msgId = UUID.getUUID(false);

            //填充对象
            TuSmsSend tss = new TuSmsSend();
            tss.setSmsMsgId(msgId); //消息ID
            tss.setSmsReceiveTime(receiveDate); //接收消息的时间
            tss.setSmsSendMan(userName); //发送人
            tss.setSmsMobileList(StringUtils.join(item.getMobiles(), ",")); //号码列表
            tss.setSmsContent(item.getContent()); //短信内容
            tss.setSmsContentBillingUnit(splitCount); //内容计费单位
            tss.setSmsMobileBillingUnit(item.getMobiles().size()); //号码计费单位
            tss.setSmsPlanTime(item.getPlanTime()); //计划发送时间
            tss.setSmsPriority(item.getPriority()); //优先级
            tss.setSmsStatus(Constants.STATUS_0); //状态
            tss.setCreateBy(userName); //创建人
            tss.setCreateDate(new Date()); //创建时间
            tss.setSuffix("" + (System.currentTimeMillis() % smsSendTableCount)); //分表
            //tss.setSmsSendTime(smsSendTime); //发送时间
            //tss.setSmsResponseStatus(smsResponseStatus); //响应状态
            //tss.setSmsResponseTime(smsResponseTime); //响应时间
            //tss.setSmsResponseMsgId(responseMsgId); //响应消息ID
            //tss.setSmsRetryCount(smsRetryCount); //重试次数
            //tss.setSmsArchiveTime(smsArchiveTime); //归档时间
            //tss.setSmsBillingTime(smsBillingTime); //结算时间
            //tss.setUpdateBy(updateBy); //修改人
            //tss.setUpdateDate(updateDate); //修改时间

            //保存
            this.tssm.insertSelective(tss);

            //记录MSGID
            msgIdList.add(msgId);
        }

        //记录其他响应值
        rv.setMsgId(msgIdList);
        rv.setResponseStatus(Constants.SEND_SMS_STATUS_0);
        rv.setResponseTime(new Date());

        //返回
        return rv;
    }

    /**
     * <p>
     * Description: 拆分消息,按照号码列表和内容拆分
     * </p>
     * 
     * @param requestSendSmsVo 请求对象
     * @return 拆分后的消息
     */
    private List<RequestSendSmsVo> smsSplit(RequestSendSmsVo requestSendSmsVo) {

        //返回值
        List<RequestSendSmsVo> rv = new ArrayList<RequestSendSmsVo>();

        //获取必要参数
        int maxMobileList = new Integer(this.getPs().getServerParamter(SystemParam.MAX_MOBILE_LIST.name())).intValue();
        int maxSmsContentLength = new Integer(this.getPs().getServerParamter(SystemParam.MAX_SMS_CONTENT_LENGTH.name()))
                .intValue();

        //先按照号码列表拆分
        List<List<String>> mobiles = new ArrayList<List<String>>();
        if (requestSendSmsVo.getMobiles().size() > maxMobileList) {

            //计算需要拆分成几条
            int counta = requestSendSmsVo.getMobiles().size() / maxMobileList;
            int countb = requestSendSmsVo.getMobiles().size() % maxMobileList == 0 ? 0 : 1;
            int splitCount = counta + countb;

            //循环
            for (int i = 0; i < splitCount; i++) {

                //计算开始坐标和结束坐标
                int start = i * maxMobileList;
                int end = maxMobileList + i * maxMobileList - 1;
                end = end > requestSendSmsVo.getMobiles().size() - 1 ? requestSendSmsVo.getMobiles().size() - 1 : end;

                //写入对象
                mobiles.add(requestSendSmsVo.getMobiles().subList(start, end));

            }

        } else {
            mobiles.add(requestSendSmsVo.getMobiles());
        }

        //再按照内容划分
        List<String> contents = new ArrayList<String>();
        if (requestSendSmsVo.getContent().length() > maxSmsContentLength) {

            //计算需要拆分成几条
            int counta = requestSendSmsVo.getContent().length() / maxSmsContentLength;
            int countb = requestSendSmsVo.getContent().length() % maxSmsContentLength == 0 ? 0 : 1;
            int splitCount = counta + countb;

            //循环
            for (int i = 0; i < splitCount; i++) {

                //计算开始坐标和结束坐标
                int start = i * maxSmsContentLength;
                int end = maxSmsContentLength + i * maxSmsContentLength - 1;
                end = end > requestSendSmsVo.getContent().length() - 1 ? requestSendSmsVo.getContent().length() - 1
                        : end;

                //写入对象
                contents.add(requestSendSmsVo.getContent().substring(start, end));

            }
        } else {
            contents.add(requestSendSmsVo.getContent());
        }

        //重新组装
        for (int i = 0; i < mobiles.size(); i++) {
            for (int j = 0; j < contents.size(); j++) {
                RequestSendSmsVo item = new RequestSendSmsVo();
                item.setContent(contents.get(j));
                item.setMobiles(mobiles.get(i));
                item.setPlanTime(requestSendSmsVo.getPlanTime());
                item.setPriority(requestSendSmsVo.getPriority());
                rv.add(item);
            }
        }

        //返回
        return rv;
    }

}
