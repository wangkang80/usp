package com.svw.usp.model.standard;

import java.io.Serializable;
import java.util.Date;

public class TuSmsArchive implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_MSG_ID
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsMsgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_MOBILE_LIST
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsMobileList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_CONTENT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_SEND_MAN
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsSendMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_RECEIVE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date smsReceiveTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_STATUS
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_RETRY_COUNT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsRetryCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_PRIORITY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsPriority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_SEND_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date smsSendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_BILLING_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date smsBillingTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_ARCHIVE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date smsArchiveTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_RESPONSE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date smsResponseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_RESPONSE_STATUS
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsResponseStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_RESPONSE_MSG_ID
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsResponseMsgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_MOBILE_BILLING_UNIT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Integer smsMobileBillingUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_CONTENT_BILLING_UNIT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Integer smsContentBillingUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.SMS_PLAN_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String smsPlanTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.CREATE_BY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.CREATE_DATE
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.UPDATE_BY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_sms_archive.UPDATE_DATE
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_MSG_ID
     *
     * @return the value of tu_sms_archive.SMS_MSG_ID
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsMsgId() {
        return smsMsgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_MSG_ID
     *
     * @param smsMsgId the value for tu_sms_archive.SMS_MSG_ID
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsMsgId(String smsMsgId) {
        this.smsMsgId = smsMsgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_MOBILE_LIST
     *
     * @return the value of tu_sms_archive.SMS_MOBILE_LIST
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsMobileList() {
        return smsMobileList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_MOBILE_LIST
     *
     * @param smsMobileList the value for tu_sms_archive.SMS_MOBILE_LIST
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsMobileList(String smsMobileList) {
        this.smsMobileList = smsMobileList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_CONTENT
     *
     * @return the value of tu_sms_archive.SMS_CONTENT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_CONTENT
     *
     * @param smsContent the value for tu_sms_archive.SMS_CONTENT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_SEND_MAN
     *
     * @return the value of tu_sms_archive.SMS_SEND_MAN
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsSendMan() {
        return smsSendMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_SEND_MAN
     *
     * @param smsSendMan the value for tu_sms_archive.SMS_SEND_MAN
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsSendMan(String smsSendMan) {
        this.smsSendMan = smsSendMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_RECEIVE_TIME
     *
     * @return the value of tu_sms_archive.SMS_RECEIVE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getSmsReceiveTime() {
        return smsReceiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_RECEIVE_TIME
     *
     * @param smsReceiveTime the value for tu_sms_archive.SMS_RECEIVE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsReceiveTime(Date smsReceiveTime) {
        this.smsReceiveTime = smsReceiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_STATUS
     *
     * @return the value of tu_sms_archive.SMS_STATUS
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsStatus() {
        return smsStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_STATUS
     *
     * @param smsStatus the value for tu_sms_archive.SMS_STATUS
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_RETRY_COUNT
     *
     * @return the value of tu_sms_archive.SMS_RETRY_COUNT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsRetryCount() {
        return smsRetryCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_RETRY_COUNT
     *
     * @param smsRetryCount the value for tu_sms_archive.SMS_RETRY_COUNT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsRetryCount(String smsRetryCount) {
        this.smsRetryCount = smsRetryCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_PRIORITY
     *
     * @return the value of tu_sms_archive.SMS_PRIORITY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsPriority() {
        return smsPriority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_PRIORITY
     *
     * @param smsPriority the value for tu_sms_archive.SMS_PRIORITY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsPriority(String smsPriority) {
        this.smsPriority = smsPriority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_SEND_TIME
     *
     * @return the value of tu_sms_archive.SMS_SEND_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getSmsSendTime() {
        return smsSendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_SEND_TIME
     *
     * @param smsSendTime the value for tu_sms_archive.SMS_SEND_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsSendTime(Date smsSendTime) {
        this.smsSendTime = smsSendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_BILLING_TIME
     *
     * @return the value of tu_sms_archive.SMS_BILLING_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getSmsBillingTime() {
        return smsBillingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_BILLING_TIME
     *
     * @param smsBillingTime the value for tu_sms_archive.SMS_BILLING_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsBillingTime(Date smsBillingTime) {
        this.smsBillingTime = smsBillingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_ARCHIVE_TIME
     *
     * @return the value of tu_sms_archive.SMS_ARCHIVE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getSmsArchiveTime() {
        return smsArchiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_ARCHIVE_TIME
     *
     * @param smsArchiveTime the value for tu_sms_archive.SMS_ARCHIVE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsArchiveTime(Date smsArchiveTime) {
        this.smsArchiveTime = smsArchiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_RESPONSE_TIME
     *
     * @return the value of tu_sms_archive.SMS_RESPONSE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getSmsResponseTime() {
        return smsResponseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_RESPONSE_TIME
     *
     * @param smsResponseTime the value for tu_sms_archive.SMS_RESPONSE_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsResponseTime(Date smsResponseTime) {
        this.smsResponseTime = smsResponseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_RESPONSE_STATUS
     *
     * @return the value of tu_sms_archive.SMS_RESPONSE_STATUS
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsResponseStatus() {
        return smsResponseStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_RESPONSE_STATUS
     *
     * @param smsResponseStatus the value for tu_sms_archive.SMS_RESPONSE_STATUS
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsResponseStatus(String smsResponseStatus) {
        this.smsResponseStatus = smsResponseStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_RESPONSE_MSG_ID
     *
     * @return the value of tu_sms_archive.SMS_RESPONSE_MSG_ID
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsResponseMsgId() {
        return smsResponseMsgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_RESPONSE_MSG_ID
     *
     * @param smsResponseMsgId the value for tu_sms_archive.SMS_RESPONSE_MSG_ID
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsResponseMsgId(String smsResponseMsgId) {
        this.smsResponseMsgId = smsResponseMsgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_MOBILE_BILLING_UNIT
     *
     * @return the value of tu_sms_archive.SMS_MOBILE_BILLING_UNIT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Integer getSmsMobileBillingUnit() {
        return smsMobileBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_MOBILE_BILLING_UNIT
     *
     * @param smsMobileBillingUnit the value for tu_sms_archive.SMS_MOBILE_BILLING_UNIT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsMobileBillingUnit(Integer smsMobileBillingUnit) {
        this.smsMobileBillingUnit = smsMobileBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_CONTENT_BILLING_UNIT
     *
     * @return the value of tu_sms_archive.SMS_CONTENT_BILLING_UNIT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Integer getSmsContentBillingUnit() {
        return smsContentBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_CONTENT_BILLING_UNIT
     *
     * @param smsContentBillingUnit the value for tu_sms_archive.SMS_CONTENT_BILLING_UNIT
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsContentBillingUnit(Integer smsContentBillingUnit) {
        this.smsContentBillingUnit = smsContentBillingUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.SMS_PLAN_TIME
     *
     * @return the value of tu_sms_archive.SMS_PLAN_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getSmsPlanTime() {
        return smsPlanTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.SMS_PLAN_TIME
     *
     * @param smsPlanTime the value for tu_sms_archive.SMS_PLAN_TIME
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setSmsPlanTime(String smsPlanTime) {
        this.smsPlanTime = smsPlanTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.CREATE_BY
     *
     * @return the value of tu_sms_archive.CREATE_BY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.CREATE_BY
     *
     * @param createBy the value for tu_sms_archive.CREATE_BY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.CREATE_DATE
     *
     * @return the value of tu_sms_archive.CREATE_DATE
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.CREATE_DATE
     *
     * @param createDate the value for tu_sms_archive.CREATE_DATE
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.UPDATE_BY
     *
     * @return the value of tu_sms_archive.UPDATE_BY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.UPDATE_BY
     *
     * @param updateBy the value for tu_sms_archive.UPDATE_BY
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_sms_archive.UPDATE_DATE
     *
     * @return the value of tu_sms_archive.UPDATE_DATE
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_sms_archive.UPDATE_DATE
     *
     * @param updateDate the value for tu_sms_archive.UPDATE_DATE
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TuSmsArchive other = (TuSmsArchive) that;
        return (this.getSmsMsgId() == null ? other.getSmsMsgId() == null : this.getSmsMsgId().equals(other.getSmsMsgId()))
            && (this.getSmsMobileList() == null ? other.getSmsMobileList() == null : this.getSmsMobileList().equals(other.getSmsMobileList()))
            && (this.getSmsContent() == null ? other.getSmsContent() == null : this.getSmsContent().equals(other.getSmsContent()))
            && (this.getSmsSendMan() == null ? other.getSmsSendMan() == null : this.getSmsSendMan().equals(other.getSmsSendMan()))
            && (this.getSmsReceiveTime() == null ? other.getSmsReceiveTime() == null : this.getSmsReceiveTime().equals(other.getSmsReceiveTime()))
            && (this.getSmsStatus() == null ? other.getSmsStatus() == null : this.getSmsStatus().equals(other.getSmsStatus()))
            && (this.getSmsRetryCount() == null ? other.getSmsRetryCount() == null : this.getSmsRetryCount().equals(other.getSmsRetryCount()))
            && (this.getSmsPriority() == null ? other.getSmsPriority() == null : this.getSmsPriority().equals(other.getSmsPriority()))
            && (this.getSmsSendTime() == null ? other.getSmsSendTime() == null : this.getSmsSendTime().equals(other.getSmsSendTime()))
            && (this.getSmsBillingTime() == null ? other.getSmsBillingTime() == null : this.getSmsBillingTime().equals(other.getSmsBillingTime()))
            && (this.getSmsArchiveTime() == null ? other.getSmsArchiveTime() == null : this.getSmsArchiveTime().equals(other.getSmsArchiveTime()))
            && (this.getSmsResponseTime() == null ? other.getSmsResponseTime() == null : this.getSmsResponseTime().equals(other.getSmsResponseTime()))
            && (this.getSmsResponseStatus() == null ? other.getSmsResponseStatus() == null : this.getSmsResponseStatus().equals(other.getSmsResponseStatus()))
            && (this.getSmsResponseMsgId() == null ? other.getSmsResponseMsgId() == null : this.getSmsResponseMsgId().equals(other.getSmsResponseMsgId()))
            && (this.getSmsMobileBillingUnit() == null ? other.getSmsMobileBillingUnit() == null : this.getSmsMobileBillingUnit().equals(other.getSmsMobileBillingUnit()))
            && (this.getSmsContentBillingUnit() == null ? other.getSmsContentBillingUnit() == null : this.getSmsContentBillingUnit().equals(other.getSmsContentBillingUnit()))
            && (this.getSmsPlanTime() == null ? other.getSmsPlanTime() == null : this.getSmsPlanTime().equals(other.getSmsPlanTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Thu Sep 25 17:26:25 CST 2014
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSmsMsgId() == null) ? 0 : getSmsMsgId().hashCode());
        result = prime * result + ((getSmsMobileList() == null) ? 0 : getSmsMobileList().hashCode());
        result = prime * result + ((getSmsContent() == null) ? 0 : getSmsContent().hashCode());
        result = prime * result + ((getSmsSendMan() == null) ? 0 : getSmsSendMan().hashCode());
        result = prime * result + ((getSmsReceiveTime() == null) ? 0 : getSmsReceiveTime().hashCode());
        result = prime * result + ((getSmsStatus() == null) ? 0 : getSmsStatus().hashCode());
        result = prime * result + ((getSmsRetryCount() == null) ? 0 : getSmsRetryCount().hashCode());
        result = prime * result + ((getSmsPriority() == null) ? 0 : getSmsPriority().hashCode());
        result = prime * result + ((getSmsSendTime() == null) ? 0 : getSmsSendTime().hashCode());
        result = prime * result + ((getSmsBillingTime() == null) ? 0 : getSmsBillingTime().hashCode());
        result = prime * result + ((getSmsArchiveTime() == null) ? 0 : getSmsArchiveTime().hashCode());
        result = prime * result + ((getSmsResponseTime() == null) ? 0 : getSmsResponseTime().hashCode());
        result = prime * result + ((getSmsResponseStatus() == null) ? 0 : getSmsResponseStatus().hashCode());
        result = prime * result + ((getSmsResponseMsgId() == null) ? 0 : getSmsResponseMsgId().hashCode());
        result = prime * result + ((getSmsMobileBillingUnit() == null) ? 0 : getSmsMobileBillingUnit().hashCode());
        result = prime * result + ((getSmsContentBillingUnit() == null) ? 0 : getSmsContentBillingUnit().hashCode());
        result = prime * result + ((getSmsPlanTime() == null) ? 0 : getSmsPlanTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}