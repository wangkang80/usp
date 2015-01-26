/**
 * SmsService.java
 * Created at 2014年9月24日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llsfw.core.common.UUID;
import com.llsfw.core.service.BaseService;
import com.llsfw.core.service.quartz.QuartzService;
import com.svw.usp.common.Constants;
import com.svw.usp.common.DesTools;
import com.svw.usp.common.DkfSmsClient;
import com.svw.usp.common.SystemParam;
import com.svw.usp.mapper.expand.TuSmsBillingMapper;
import com.svw.usp.mapper.expand.TuSmsSendMapper;
import com.svw.usp.mapper.standard.TuSmsArchiveMapper;
import com.svw.usp.mapper.standard.TuSmsChannelMapper;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.model.expand.TuSmsBilling;
import com.svw.usp.model.standard.TuSmsArchive;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.model.standard.TuUser;

/**
 * <p>
 * ClassName: SmsService
 * </p>
 * <p>
 * Description: sms消息计划任务服务
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月24日
 * </p>
 */
@Service("schSmsService")
public class SmsService extends BaseService implements ISmsServices {

    /**
     * <p>
     * Field s: Scheduler服务
     * </p>
     */
    @Autowired
    private QuartzService s;

    /**
     * <p>
     * Field tssm: sms记录dao
     * </p>
     */
    @Autowired
    private TuSmsSendMapper tssm;

    /**
     * <p>
     * Field tsbm: 结算dao
     * </p>
     */
    @Autowired
    private TuSmsBillingMapper tsbm;

    /**
     * <p>
     * Field tsam: 归档dao
     * </p>
     */
    @Autowired
    private TuSmsArchiveMapper tsam;

    /**
     * <p>
     * Field tum: 用户dao
     * </p>
     */
    @Autowired
    private TuUserMapper tum;

    /**
     * <p>
     * Field tscm: 通道dao
     * </p>
     */
    @Autowired
    private TuSmsChannelMapper tscm;

    @Override
    public void billingSms(String tableName) throws Exception {

        //获得必要参数
        String sendSmsMaxBillingCount = this.getPs().getServerParamter(SystemParam.SEND_SMS_MAX_BILLING_COUNT.name());

        //抓取待结算的用户清单
        List<String> userList = this.tsbm.loadBillingUserList(tableName);

        //如果有数据,则做后续操作
        if (!CollectionUtils.isEmpty(userList)) {
            for (String userName : userList) {

                //锁定用户
                Integer lastSmsCount = null;
                try {
                    lastSmsCount = new Integer(this.tsbm.lockUserLastSmsCountAndReturn(userName));
                } catch (Throwable e) {
                    this.log.info("lock user [" + userName + "] fail , this time continue");
                    continue;
                }

                //成功获取到剩余消息数量后,进行后续操作
                if (lastSmsCount != null) {

                    //获取用户待结算消息列表
                    List<Map<String, Object>> userBillingSmsList = this.tsbm.loadBillingSmsData(tableName, userName,
                            sendSmsMaxBillingCount);

                    //如果获取到了数据,则继续
                    if (!CollectionUtils.isEmpty(userBillingSmsList)) {

                        //日志输出
                        this.log.info(" this time user [" + userName + "] billing sms count "
                                + userBillingSmsList.size() + " at table [" + tableName + "]");

                        //累计结算数据
                        int sumBilling = 0;

                        //循环处理
                        for (Map<String, Object> item : userBillingSmsList) {

                            //获取数据
                            String msgId = item.get("SMS_MSG_ID").toString();
                            String channelCode = item.get("CHANNEL_CODE") == null ? null : item.get("CHANNEL_CODE")
                                    .toString();
                            String smsStatus = item.get("SMS_STATUS").toString();
                            long retryCount = Long.parseLong(item.get("SMS_RETRY_COUNT").toString());
                            int smsMobileBillingUnit = item.get("SMS_MOBILE_BILLING_UNIT") == null ? 0 : Integer
                                    .parseInt(item.get("SMS_MOBILE_BILLING_UNIT").toString());
                            int smsContentBillingUnit = item.get("SMS_CONTENT_BILLING_UNIT") == null ? 0 : Integer
                                    .parseInt(item.get("SMS_CONTENT_BILLING_UNIT").toString());
                            String planTime = item.get("SMS_PLAN_TIME") == null ? null : item.get("SMS_PLAN_TIME")
                                    .toString();

                            //只结算发送成功的数据
                            if (smsStatus.equals(Constants.STATUS_1)) {
                                sumBilling = sumBilling + smsMobileBillingUnit * smsContentBillingUnit;
                            }

                            //数据流转
                            TuSmsArchive tsa = new TuSmsArchive();
                            tsa.setSmsMsgId(msgId); //消息ID
                            tsa.setChannelCode(channelCode);
                            tsa.setSmsReceiveTime((Date) item.get("SMS_RECEIVE_TIME")); //接收消息的时间
                            tsa.setSmsSendMan(item.get("SMS_SEND_MAN").toString()); //发送人
                            tsa.setSmsMobileList(item.get("SMS_MOBILE_LIST").toString()); //号码列表
                            tsa.setSmsContent(item.get("SMS_CONTENT").toString()); //短信内容
                            tsa.setSmsContentBillingUnit(Integer.parseInt(smsContentBillingUnit + "")); //内容计费单位
                            tsa.setSmsMobileBillingUnit(Integer.parseInt(smsMobileBillingUnit + "")); //号码计费单位
                            tsa.setSmsPlanTime(planTime); //计划发送时间
                            tsa.setSmsPriority(item.get("SMS_PRIORITY").toString()); //优先级
                            tsa.setSmsStatus(smsStatus); //状态
                            tsa.setCreateBy(item.get("CREATE_BY").toString()); //创建人
                            tsa.setCreateDate((Date) item.get("CREATE_DATE")); //创建时间
                            tsa.setSmsSendTime((Date) item.get("SMS_SEND_TIME")); //发送时间
                            tsa.setSmsResponseStatus(item.get("SMS_RESPONSE_STATUS").toString()); //响应状态
                            tsa.setSmsResponseTime((Date) item.get("SMS_RESPONSE_TIME")); //响应时间
                            tsa.setSmsResponseMsgId(item.get("SMS_RESPONSE_MSG_ID").toString()); //响应消息ID
                            tsa.setSmsRetryCount(retryCount + ""); //重试次数
                            tsa.setSmsArchiveTime(new Date()); //归档时间
                            tsa.setSmsBillingTime(new Date()); //结算时间
                            tsa.setUpdateBy(com.llsfw.core.common.Constants.DEF_USER_NAME); //修改人
                            tsa.setUpdateDate(new Date()); //修改时间

                            //保存到归档表中
                            this.tsam.insertSelective(tsa);

                            //删除结算表里的数据
                            this.tsbm.deleteBillingSmsData(tableName, msgId);

                        }

                        //更新剩余短信条数
                        TuUser user = new TuUser();
                        user.setUserName(userName);
                        user.setLastSmsCount(lastSmsCount - sumBilling);
                        user.setUpdateBy(com.llsfw.core.common.Constants.DEF_USER_NAME);
                        user.setUpdateDate(new Date());
                        this.tum.updateByPrimaryKeySelective(user);
                    }
                }
            }
        }
    }

    @Override
    public void sendSms(String tableName) throws Exception {

        //抓取数据
        String sendSmsMaxExecCount = this.getPs().getServerParamter(SystemParam.SEND_SMS_MAX_EXEC_COUNT.name());
        List<Map<String, Object>> smsList = this.tssm.loadSendSmsData(tableName, sendSmsMaxExecCount);

        //如果有数据,则做后续操作
        if (!CollectionUtils.isEmpty(smsList)) {

            //短信网关连接缓存
            Map<String, DkfSmsClient> clientCache = new HashMap<String, DkfSmsClient>();

            //获得必要参数
            String sendReal = this.getPs().getServerParamter(SystemParam.SEND_REAL.name());
            long sendRealSleepTime = Long.parseLong(this.getPs().getServerParamter(
                    SystemParam.SEND_REAL_SLEEP_TIME.name()));
            long smsBillingTableCount = Long.parseLong(this.getPs().getServerParamter(
                    SystemParam.SMS_BILLING_TABLE_COUNT.name()));

            //日志输出
            this.log.info(" this time send sms count " + smsList.size() + " at table [" + tableName + "]");

            //循环处理
            for (int i = 0, max = smsList.size(); i < max; i++) {

                //获取数据
                Map<String, Object> item = smsList.get(i);

                //主要的数据
                String msgId = item.get("SMS_MSG_ID").toString();
                String channelCode = item.get("CHANNEL_CODE") == null ? null : item.get("CHANNEL_CODE").toString();
                long retryCount = Long.parseLong(item.get("SMS_RETRY_COUNT").toString());
                String smsStatus = item.get("SMS_STATUS").toString();

                //获得连接对象
                DkfSmsClient client = clientCache.get(channelCode);
                if (client == null) {
                    //获得通道配置对象
                    TuSmsChannel tsc = this.tscm.selectByPrimaryKey(channelCode);
                    String dkfWebserviceUrl = tsc.getChannelHost();
                    String dkfWebserviceUserName = tsc.getChannelUserName();
                    String dkfWebservicePassword = tsc.getChannelPassword();
                    String dkfWebserviceSecretKey = tsc.getChannelSecretKey();

                    //加密用户名和密码
                    dkfWebserviceUserName = DesTools.encrypt(dkfWebserviceUserName, dkfWebserviceSecretKey);
                    dkfWebservicePassword = DesTools.encrypt(dkfWebservicePassword, dkfWebserviceSecretKey);

                    //初始化短信发送服务
                    client = new DkfSmsClient(dkfWebserviceUrl, dkfWebserviceUserName, dkfWebservicePassword,
                            dkfWebserviceSecretKey);

                    //放入缓存
                    clientCache.put(channelCode, client);
                    this.log.info("put client cache code is " + channelCode);
                }

                //变量声明
                String planTime = null;
                Date responseDate = null;
                String responseStatus = null;
                String responseMsgId = null;
                Date sendDate = null;
                String mobiles = null;
                String content = null;

                //从try包裹,一条数据有问题,不会影响整体
                try {

                    //获取字段数据(可能为空)
                    planTime = item.get("SMS_PLAN_TIME") == null ? null : item.get("SMS_PLAN_TIME").toString();
                    responseDate = item.get("SMS_RESPONSE_TIME") == null ? null : new SimpleDateFormat(
                            "yyyy-MM-dd hh:mm:ss").parse(item.get("SMS_RESPONSE_TIME").toString());
                    responseStatus = item.get("SMS_RESPONSE_STATUS") == null ? null : item.get("SMS_RESPONSE_STATUS")
                            .toString();
                    responseMsgId = item.get("SMS_RESPONSE_MSG_ID") == null ? null : item.get("SMS_RESPONSE_MSG_ID")
                            .toString();
                    sendDate = item.get("SMS_SEND_TIME") == null ? null : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                            .parse(item.get("SMS_SEND_TIME").toString());

                    //获取字段(不会为空)
                    mobiles = item.get("SMS_MOBILE_LIST").toString();
                    content = item.get("SMS_CONTENT").toString();

                    //只处理待发送的数据(避免由于自身异常,导致无限重复发送消息,造成资源浪费和损失)
                    if (smsStatus.equals(Constants.STATUS_0)) {

                        //将号码列表转换为数组
                        String[] mobilesArray = mobiles.split(",");

                        //接口数据加密
                        String desContent = DesTools.encrypt(content, client.dkfWebserviceSecretKey);
                        for (int j = 0; j < mobilesArray.length; j++) {
                            mobilesArray[j] = DesTools.encrypt(mobilesArray[j], client.dkfWebserviceSecretKey);
                        }

                        //发送消息,这里判断是真发送还是模拟发送(0:假发送,1:真发送)[主要为了,应付特殊情况,如:压力测试等],
                        String result = null;
                        if (sendReal.equals(Constants.STATUS_1)) { //真发送
                            result = client.sendSms(client.dkfWebserviceUserName, client.dkfWebservicePassword,
                                    mobilesArray, desContent, planTime, null);
                        } else { //假发送
                            Thread.sleep(sendRealSleepTime);
                            result = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "," + 0 + ","
                                    + UUID.getUUID(false);
                        }

                        //记录发送时间
                        sendDate = new Date();

                        //处理结果
                        this.log.info("DKF RESULT : " + result);
                        String[] results = result.split(",");
                        responseDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(results[0]);
                        responseStatus = results[1];
                        if (results.length >= 3) { //有可能没有MSG_ID
                            responseMsgId = results[2];
                        }

                        //判断发送结果,短信平台反馈发送是失败,则这条消息就是发送失败的
                        if (responseStatus.equals(Constants.STATUS_0)) {
                            smsStatus = Constants.STATUS_1;
                        } else {
                            smsStatus = Constants.STATUS_2;
                        }

                    } else {
                        //状态已经不是[待发送],说明在尝试数据流转到计费表中的时候出错,这里重试次数+1代表的是
                        //再一次尝试流转数据
                        retryCount = retryCount + 1;
                    }

                    //数据流转,写入到计费表中
                    TuSmsBilling tsb = new TuSmsBilling();
                    tsb.setSmsMsgId(msgId); //消息ID
                    tsb.setChannelCode(channelCode);//通道代码
                    tsb.setSmsReceiveTime((Date) item.get("SMS_RECEIVE_TIME")); //接收消息的时间
                    tsb.setSmsSendMan(item.get("SMS_SEND_MAN").toString()); //发送人
                    tsb.setSmsMobileList(mobiles); //号码列表
                    tsb.setSmsContent(content); //短信内容
                    tsb.setSmsContentBillingUnit(Integer.parseInt(item.get("SMS_CONTENT_BILLING_UNIT").toString())); //内容计费单位
                    tsb.setSmsMobileBillingUnit(Integer.parseInt(item.get("SMS_MOBILE_BILLING_UNIT").toString())); //号码计费单位
                    tsb.setSmsPlanTime(planTime); //计划发送时间
                    tsb.setSmsPriority(item.get("SMS_PRIORITY").toString()); //优先级
                    tsb.setSmsStatus(smsStatus); //状态
                    tsb.setCreateBy(item.get("CREATE_BY").toString()); //创建人
                    tsb.setCreateDate((Date) item.get("CREATE_DATE")); //创建时间
                    tsb.setSuffix("" + (System.currentTimeMillis() % smsBillingTableCount)); //分表
                    tsb.setSmsSendTime(sendDate); //发送时间
                    tsb.setSmsResponseStatus(responseStatus); //响应状态
                    tsb.setSmsResponseTime(responseDate); //响应时间
                    tsb.setSmsResponseMsgId(responseMsgId); //响应消息ID 2015年1月26日 responseMsgId有可能为空
                    tsb.setSmsRetryCount(retryCount + ""); //重试次数
                    //tss.setSmsArchiveTime(smsArchiveTime); //归档时间
                    //tss.setSmsBillingTime(smsBillingTime); //结算时间
                    tsb.setUpdateBy(com.llsfw.core.common.Constants.DEF_USER_NAME); //修改人
                    tsb.setUpdateDate(new Date()); //修改时间

                    //保存到计费表中
                    this.tsbm.insertSelective(tsb);

                    //删除发送表里的数据
                    this.tssm.deleteSendSmsData(tableName, msgId);

                } catch (Throwable e) {
                    //更新数据状态
                    retryCount = retryCount + 1;
                    this.tssm.updateSendSmsData(tableName, msgId, smsStatus, "" + retryCount, sendDate, responseDate,
                            responseStatus, responseMsgId, com.llsfw.core.common.Constants.DEF_USER_NAME, new Date());
                    this.log.error("发送消息错误:", e);
                }
            }
        }

    }

    @Override
    public void fastTriggerBilling(JobKey key, String tableName) throws Exception {
        if (this.tsbm.loadBillingUserList(tableName).size() > 0) {
            this.s.schedulerOp("triggerJob", key.getName(), key.getGroup(), null, null);
        }
    }

    @Override
    public void fastTriggerSend(JobKey key, String tableName) throws Exception {
        if (this.tssm.countSendDataStatus0(tableName) > 0) {
            this.s.schedulerOp("triggerJob", key.getName(), key.getGroup(), null, null);
        }
    }

    @Override
    public void clearTuUser() {
        StringBuffer sb = new StringBuffer();
        sb.append(" DELETE FROM TU_USER WHERE USER_NAME IN ( ");
        sb.append("     SELECT USER_NAME FROM ( ");
        sb.append("         SELECT A.USER_NAME FROM TU_USER A ");
        sb.append("         LEFT JOIN TT_APPLICATION_USER B ON A.USER_NAME=B.LOGIN_NAME ");
        sb.append("         WHERE B.LOGIN_NAME IS NULL ");
        sb.append("     ) C ");
        sb.append(" ) ");
        this.getImqm().delete(sb.toString());
    }
}
