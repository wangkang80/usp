package com.svw.usp.mapper.standard;

import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.model.standard.TuSmsChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TuSmsChannelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int countByExample(TuSmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int deleteByExample(TuSmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int deleteByPrimaryKey(String channelCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int insert(TuSmsChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int insertSelective(TuSmsChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    List<TuSmsChannel> selectByExample(TuSmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    TuSmsChannel selectByPrimaryKey(String channelCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByExampleSelective(@Param("record") TuSmsChannel record, @Param("example") TuSmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByExample(@Param("record") TuSmsChannel record, @Param("example") TuSmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByPrimaryKeySelective(TuSmsChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_channel
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByPrimaryKey(TuSmsChannel record);
}