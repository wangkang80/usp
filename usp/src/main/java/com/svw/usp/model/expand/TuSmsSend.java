package com.svw.usp.model.expand;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ClassName: TuSmsSend
 * </p>
 * <p>
 * Description: TODO
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月14日
 * </p>
 */
public class TuSmsSend implements Serializable {

    /**
     * <p>
     * Field smsResponseMsgId: 响应消息ID
     * </p>
     */
    private String smsResponseMsgId;

    /**
     * <p>
     * Field channelCode: 通道代码
     * </p>
     */
    private String channelCode;

    /**
     * <p>
     * Field suffix: 分表标志
     * </p>
     */
    private String suffix;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_MSG_ID
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsMsgId;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_MOBILE_LIST
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsMobileList;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_CONTENT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsContent;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_SEND_MAN
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsSendMan;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_RECEIVE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date smsReceiveTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_STATUS
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsStatus;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_RETRY_COUNT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsRetryCount;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_PRIORITY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsPriority;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_SEND_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date smsSendTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_BILLING_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date smsBillingTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_ARCHIVE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date smsArchiveTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_RESPONSE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date smsResponseTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_RESPONSE_STATUS
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsResponseStatus;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_MOBILE_BILLING_UNIT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Integer smsMobileBillingUnit;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_CONTENT_BILLING_UNIT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Integer smsContentBillingUnit;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.SMS_PLAN_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String smsPlanTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.CREATE_BY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.CREATE_DATE
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.UPDATE_BY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column tu_sms_send_0.UPDATE_DATE
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database table tu_sms_send_0
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_MSG_ID
     * 
     * @return the value of tu_sms_send_0.SMS_MSG_ID
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsMsgId() {
        return smsMsgId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_MSG_ID
     * 
     * @param smsMsgId the value for tu_sms_send_0.SMS_MSG_ID
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsMsgId(String smsMsgId) {
        this.smsMsgId = smsMsgId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_MOBILE_LIST
     * 
     * @return the value of tu_sms_send_0.SMS_MOBILE_LIST
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsMobileList() {
        return smsMobileList;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_MOBILE_LIST
     * 
     * @param smsMobileList the value for tu_sms_send_0.SMS_MOBILE_LIST
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsMobileList(String smsMobileList) {
        this.smsMobileList = smsMobileList;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_CONTENT
     * 
     * @return the value of tu_sms_send_0.SMS_CONTENT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_CONTENT
     * 
     * @param smsContent the value for tu_sms_send_0.SMS_CONTENT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_SEND_MAN
     * 
     * @return the value of tu_sms_send_0.SMS_SEND_MAN
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsSendMan() {
        return smsSendMan;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_SEND_MAN
     * 
     * @param smsSendMan the value for tu_sms_send_0.SMS_SEND_MAN
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsSendMan(String smsSendMan) {
        this.smsSendMan = smsSendMan;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_RECEIVE_TIME
     * 
     * @return the value of tu_sms_send_0.SMS_RECEIVE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getSmsReceiveTime() {
        return smsReceiveTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_RECEIVE_TIME
     * 
     * @param smsReceiveTime the value for tu_sms_send_0.SMS_RECEIVE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsReceiveTime(Date smsReceiveTime) {
        this.smsReceiveTime = smsReceiveTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_STATUS
     * 
     * @return the value of tu_sms_send_0.SMS_STATUS
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsStatus() {
        return smsStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_STATUS
     * 
     * @param smsStatus the value for tu_sms_send_0.SMS_STATUS
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_RETRY_COUNT
     * 
     * @return the value of tu_sms_send_0.SMS_RETRY_COUNT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsRetryCount() {
        return smsRetryCount;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_RETRY_COUNT
     * 
     * @param smsRetryCount the value for tu_sms_send_0.SMS_RETRY_COUNT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsRetryCount(String smsRetryCount) {
        this.smsRetryCount = smsRetryCount;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_PRIORITY
     * 
     * @return the value of tu_sms_send_0.SMS_PRIORITY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsPriority() {
        return smsPriority;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_PRIORITY
     * 
     * @param smsPriority the value for tu_sms_send_0.SMS_PRIORITY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsPriority(String smsPriority) {
        this.smsPriority = smsPriority;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_SEND_TIME
     * 
     * @return the value of tu_sms_send_0.SMS_SEND_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getSmsSendTime() {
        return smsSendTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_SEND_TIME
     * 
     * @param smsSendTime the value for tu_sms_send_0.SMS_SEND_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsSendTime(Date smsSendTime) {
        this.smsSendTime = smsSendTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_BILLING_TIME
     * 
     * @return the value of tu_sms_send_0.SMS_BILLING_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getSmsBillingTime() {
        return smsBillingTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_BILLING_TIME
     * 
     * @param smsBillingTime the value for tu_sms_send_0.SMS_BILLING_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsBillingTime(Date smsBillingTime) {
        this.smsBillingTime = smsBillingTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_ARCHIVE_TIME
     * 
     * @return the value of tu_sms_send_0.SMS_ARCHIVE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getSmsArchiveTime() {
        return smsArchiveTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_ARCHIVE_TIME
     * 
     * @param smsArchiveTime the value for tu_sms_send_0.SMS_ARCHIVE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsArchiveTime(Date smsArchiveTime) {
        this.smsArchiveTime = smsArchiveTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_RESPONSE_TIME
     * 
     * @return the value of tu_sms_send_0.SMS_RESPONSE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getSmsResponseTime() {
        return smsResponseTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_RESPONSE_TIME
     * 
     * @param smsResponseTime the value for tu_sms_send_0.SMS_RESPONSE_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsResponseTime(Date smsResponseTime) {
        this.smsResponseTime = smsResponseTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_RESPONSE_STATUS
     * 
     * @return the value of tu_sms_send_0.SMS_RESPONSE_STATUS
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsResponseStatus() {
        return smsResponseStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_RESPONSE_STATUS
     * 
     * @param smsResponseStatus the value for tu_sms_send_0.SMS_RESPONSE_STATUS
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsResponseStatus(String smsResponseStatus) {
        this.smsResponseStatus = smsResponseStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_MOBILE_BILLING_UNIT
     * 
     * @return the value of tu_sms_send_0.SMS_MOBILE_BILLING_UNIT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Integer getSmsMobileBillingUnit() {
        return smsMobileBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_MOBILE_BILLING_UNIT
     * 
     * @param smsMobileBillingUnit the value for
     *            tu_sms_send_0.SMS_MOBILE_BILLING_UNIT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsMobileBillingUnit(Integer smsMobileBillingUnit) {
        this.smsMobileBillingUnit = smsMobileBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_CONTENT_BILLING_UNIT
     * 
     * @return the value of tu_sms_send_0.SMS_CONTENT_BILLING_UNIT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Integer getSmsContentBillingUnit() {
        return smsContentBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_CONTENT_BILLING_UNIT
     * 
     * @param smsContentBillingUnit the value for
     *            tu_sms_send_0.SMS_CONTENT_BILLING_UNIT
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsContentBillingUnit(Integer smsContentBillingUnit) {
        this.smsContentBillingUnit = smsContentBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.SMS_PLAN_TIME
     * 
     * @return the value of tu_sms_send_0.SMS_PLAN_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getSmsPlanTime() {
        return smsPlanTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.SMS_PLAN_TIME
     * 
     * @param smsPlanTime the value for tu_sms_send_0.SMS_PLAN_TIME
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setSmsPlanTime(String smsPlanTime) {
        this.smsPlanTime = smsPlanTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.CREATE_BY
     * 
     * @return the value of tu_sms_send_0.CREATE_BY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.CREATE_BY
     * 
     * @param createBy the value for tu_sms_send_0.CREATE_BY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.CREATE_DATE
     * 
     * @return the value of tu_sms_send_0.CREATE_DATE
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.CREATE_DATE
     * 
     * @param createDate the value for tu_sms_send_0.CREATE_DATE
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.UPDATE_BY
     * 
     * @return the value of tu_sms_send_0.UPDATE_BY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.UPDATE_BY
     * 
     * @param updateBy the value for tu_sms_send_0.UPDATE_BY
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column tu_sms_send_0.UPDATE_DATE
     * 
     * @return the value of tu_sms_send_0.UPDATE_DATE
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column tu_sms_send_0.UPDATE_DATE
     * 
     * @param updateDate the value for tu_sms_send_0.UPDATE_DATE
     * 
     * @mbggenerated Tue Sep 23 14:17:00 CST 2014
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSmsResponseMsgId() {
        return smsResponseMsgId;
    }

    public void setSmsResponseMsgId(String smsResponseMsgId) {
        this.smsResponseMsgId = smsResponseMsgId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

}
