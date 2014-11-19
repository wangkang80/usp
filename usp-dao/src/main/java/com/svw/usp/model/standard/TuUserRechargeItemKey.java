package com.svw.usp.model.standard;

import java.io.Serializable;

public class TuUserRechargeItemKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.RECHARGE_CODE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private String rechargeCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tu_user_recharge_item.BE_PREPAID
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private String bePrepaid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tu_user_recharge_item
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.RECHARGE_CODE
     *
     * @return the value of tu_user_recharge_item.RECHARGE_CODE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public String getRechargeCode() {
        return rechargeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.RECHARGE_CODE
     *
     * @param rechargeCode the value for tu_user_recharge_item.RECHARGE_CODE
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setRechargeCode(String rechargeCode) {
        this.rechargeCode = rechargeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tu_user_recharge_item.BE_PREPAID
     *
     * @return the value of tu_user_recharge_item.BE_PREPAID
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public String getBePrepaid() {
        return bePrepaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tu_user_recharge_item.BE_PREPAID
     *
     * @param bePrepaid the value for tu_user_recharge_item.BE_PREPAID
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    public void setBePrepaid(String bePrepaid) {
        this.bePrepaid = bePrepaid;
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
        TuUserRechargeItemKey other = (TuUserRechargeItemKey) that;
        return (this.getRechargeCode() == null ? other.getRechargeCode() == null : this.getRechargeCode().equals(other.getRechargeCode()))
            && (this.getBePrepaid() == null ? other.getBePrepaid() == null : this.getBePrepaid().equals(other.getBePrepaid()));
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
        return result;
    }
}