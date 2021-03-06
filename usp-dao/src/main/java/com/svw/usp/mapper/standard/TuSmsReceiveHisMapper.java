package com.svw.usp.mapper.standard;

import com.svw.usp.model.standard.TuSmsReceiveHis;
import com.svw.usp.model.standard.TuSmsReceiveHisCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TuSmsReceiveHisMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int countByExample(TuSmsReceiveHisCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int deleteByExample(TuSmsReceiveHisCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int deleteByPrimaryKey(String smsMsgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int insert(TuSmsReceiveHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int insertSelective(TuSmsReceiveHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    List<TuSmsReceiveHis> selectByExample(TuSmsReceiveHisCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    TuSmsReceiveHis selectByPrimaryKey(String smsMsgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByExampleSelective(@Param("record") TuSmsReceiveHis record, @Param("example") TuSmsReceiveHisCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByExample(@Param("record") TuSmsReceiveHis record, @Param("example") TuSmsReceiveHisCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByPrimaryKeySelective(TuSmsReceiveHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_receive_his
     *
     * @mbggenerated Wed Nov 19 13:45:24 CST 2014
     */
    int updateByPrimaryKey(TuSmsReceiveHis record);
}