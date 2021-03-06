package com.svw.usp.model.standard;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TuUserRechargeItem extends TuUserRechargeItemKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_TOTAL_PRICE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private BigDecimal smsTotalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_UNIT_PRICE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private BigDecimal smsUnitPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_PLAN_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Integer smsPlanCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_REAL_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Integer smsRealCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_BFORE_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Integer smsBforeCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_AFTER_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Integer smsAfterCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.SMS_RECHARGE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Date smsRechargeDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.RECHARGE_STATUS
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private String rechargeStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.CREATE_BY
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.CREATE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.UPDATE_BY
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.UPDATE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tu_user_recharge_item
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_TOTAL_PRICE
     *
     * @return the value of tu_user_recharge_item.SMS_TOTAL_PRICE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public BigDecimal getSmsTotalPrice() {
        return smsTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_TOTAL_PRICE
     *
     * @param smsTotalPrice the value for tu_user_recharge_item.SMS_TOTAL_PRICE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsTotalPrice(BigDecimal smsTotalPrice) {
        this.smsTotalPrice = smsTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_UNIT_PRICE
     *
     * @return the value of tu_user_recharge_item.SMS_UNIT_PRICE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public BigDecimal getSmsUnitPrice() {
        return smsUnitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_UNIT_PRICE
     *
     * @param smsUnitPrice the value for tu_user_recharge_item.SMS_UNIT_PRICE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsUnitPrice(BigDecimal smsUnitPrice) {
        this.smsUnitPrice = smsUnitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_PLAN_COUNT
     *
     * @return the value of tu_user_recharge_item.SMS_PLAN_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Integer getSmsPlanCount() {
        return smsPlanCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_PLAN_COUNT
     *
     * @param smsPlanCount the value for tu_user_recharge_item.SMS_PLAN_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsPlanCount(Integer smsPlanCount) {
        this.smsPlanCount = smsPlanCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_REAL_COUNT
     *
     * @return the value of tu_user_recharge_item.SMS_REAL_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Integer getSmsRealCount() {
        return smsRealCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_REAL_COUNT
     *
     * @param smsRealCount the value for tu_user_recharge_item.SMS_REAL_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsRealCount(Integer smsRealCount) {
        this.smsRealCount = smsRealCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_BFORE_COUNT
     *
     * @return the value of tu_user_recharge_item.SMS_BFORE_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Integer getSmsBforeCount() {
        return smsBforeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_BFORE_COUNT
     *
     * @param smsBforeCount the value for tu_user_recharge_item.SMS_BFORE_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsBforeCount(Integer smsBforeCount) {
        this.smsBforeCount = smsBforeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_AFTER_COUNT
     *
     * @return the value of tu_user_recharge_item.SMS_AFTER_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Integer getSmsAfterCount() {
        return smsAfterCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_AFTER_COUNT
     *
     * @param smsAfterCount the value for tu_user_recharge_item.SMS_AFTER_COUNT
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsAfterCount(Integer smsAfterCount) {
        this.smsAfterCount = smsAfterCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.SMS_RECHARGE_DATE
     *
     * @return the value of tu_user_recharge_item.SMS_RECHARGE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Date getSmsRechargeDate() {
        return smsRechargeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.SMS_RECHARGE_DATE
     *
     * @param smsRechargeDate the value for tu_user_recharge_item.SMS_RECHARGE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setSmsRechargeDate(Date smsRechargeDate) {
        this.smsRechargeDate = smsRechargeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.RECHARGE_STATUS
     *
     * @return the value of tu_user_recharge_item.RECHARGE_STATUS
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public String getRechargeStatus() {
        return rechargeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.RECHARGE_STATUS
     *
     * @param rechargeStatus the value for tu_user_recharge_item.RECHARGE_STATUS
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.CREATE_BY
     *
     * @return the value of tu_user_recharge_item.CREATE_BY
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.CREATE_BY
     *
     * @param createBy the value for tu_user_recharge_item.CREATE_BY
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.CREATE_DATE
     *
     * @return the value of tu_user_recharge_item.CREATE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.CREATE_DATE
     *
     * @param createDate the value for tu_user_recharge_item.CREATE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.UPDATE_BY
     *
     * @return the value of tu_user_recharge_item.UPDATE_BY
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.UPDATE_BY
     *
     * @param updateBy the value for tu_user_recharge_item.UPDATE_BY
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.UPDATE_DATE
     *
     * @return the value of tu_user_recharge_item.UPDATE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.UPDATE_DATE
     *
     * @param updateDate the value for tu_user_recharge_item.UPDATE_DATE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_user_recharge_item
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
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
        TuUserRechargeItem other = (TuUserRechargeItem) that;
        return (this.getRechargeCode() == null ? other.getRechargeCode() == null : this.getRechargeCode().equals(other.getRechargeCode()))
            && (this.getBePrepaid() == null ? other.getBePrepaid() == null : this.getBePrepaid().equals(other.getBePrepaid()))
            && (this.getSmsTotalPrice() == null ? other.getSmsTotalPrice() == null : this.getSmsTotalPrice().equals(other.getSmsTotalPrice()))
            && (this.getSmsUnitPrice() == null ? other.getSmsUnitPrice() == null : this.getSmsUnitPrice().equals(other.getSmsUnitPrice()))
            && (this.getSmsPlanCount() == null ? other.getSmsPlanCount() == null : this.getSmsPlanCount().equals(other.getSmsPlanCount()))
            && (this.getSmsRealCount() == null ? other.getSmsRealCount() == null : this.getSmsRealCount().equals(other.getSmsRealCount()))
            && (this.getSmsBforeCount() == null ? other.getSmsBforeCount() == null : this.getSmsBforeCount().equals(other.getSmsBforeCount()))
            && (this.getSmsAfterCount() == null ? other.getSmsAfterCount() == null : this.getSmsAfterCount().equals(other.getSmsAfterCount()))
            && (this.getSmsRechargeDate() == null ? other.getSmsRechargeDate() == null : this.getSmsRechargeDate().equals(other.getSmsRechargeDate()))
            && (this.getRechargeStatus() == null ? other.getRechargeStatus() == null : this.getRechargeStatus().equals(other.getRechargeStatus()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_user_recharge_item
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRechargeCode() == null) ? 0 : getRechargeCode().hashCode());
        result = prime * result + ((getBePrepaid() == null) ? 0 : getBePrepaid().hashCode());
        result = prime * result + ((getSmsTotalPrice() == null) ? 0 : getSmsTotalPrice().hashCode());
        result = prime * result + ((getSmsUnitPrice() == null) ? 0 : getSmsUnitPrice().hashCode());
        result = prime * result + ((getSmsPlanCount() == null) ? 0 : getSmsPlanCount().hashCode());
        result = prime * result + ((getSmsRealCount() == null) ? 0 : getSmsRealCount().hashCode());
        result = prime * result + ((getSmsBforeCount() == null) ? 0 : getSmsBforeCount().hashCode());
        result = prime * result + ((getSmsAfterCount() == null) ? 0 : getSmsAfterCount().hashCode());
        result = prime * result + ((getSmsRechargeDate() == null) ? 0 : getSmsRechargeDate().hashCode());
        result = prime * result + ((getRechargeStatus() == null) ? 0 : getRechargeStatus().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}