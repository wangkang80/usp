package com.svw.usp.mapper.standard;

import com.svw.usp.model.standard.TuSmsArchive;
import com.svw.usp.model.standard.TuSmsArchiveCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TuSmsArchiveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int countByExample(TuSmsArchiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int deleteByExample(TuSmsArchiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int deleteByPrimaryKey(String smsMsgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int insert(TuSmsArchive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int insertSelective(TuSmsArchive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    List<TuSmsArchive> selectByExample(TuSmsArchiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    TuSmsArchive selectByPrimaryKey(String smsMsgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int updateByExampleSelective(@Param("record") TuSmsArchive record, @Param("example") TuSmsArchiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int updateByExample(@Param("record") TuSmsArchive record, @Param("example") TuSmsArchiveCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int updateByPrimaryKeySelective(TuSmsArchive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tu_sms_archive
     *
     * @mbggenerated Fri Sep 26 09:57:55 CST 2014
     */
    int updateByPrimaryKey(TuSmsArchive record);
}