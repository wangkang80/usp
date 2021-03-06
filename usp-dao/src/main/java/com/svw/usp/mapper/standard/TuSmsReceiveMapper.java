package com.svw.usp.mapper.standard;

import com.svw.usp.model.standard.TuSmsReceive;
import com.svw.usp.model.standard.TuSmsReceiveCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TuSmsReceiveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int countByExample(TuSmsReceiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int deleteByExample(TuSmsReceiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int deleteByPrimaryKey(String smsMsgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int insert(TuSmsReceive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int insertSelective(TuSmsReceive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    List<TuSmsReceive> selectByExample(TuSmsReceiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    TuSmsReceive selectByPrimaryKey(String smsMsgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByExampleSelective(@Param("record") TuSmsReceive record, @Param("example") TuSmsReceiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByExample(@Param("record") TuSmsReceive record, @Param("example") TuSmsReceiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByPrimaryKeySelective(TuSmsReceive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByPrimaryKey(TuSmsReceive record);
}