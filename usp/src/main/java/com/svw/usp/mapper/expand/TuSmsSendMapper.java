package com.svw.usp.mapper.expand;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.svw.usp.model.expand.TuSmsSend;

public interface TuSmsSendMapper {

    /**
     * <p>
     * Description: 判断是否有数据存在(状态为0)
     * </p>
     * 
     * @param tableName 表名
     * @return 结果
     */
    int countSendDataStatus0(@Param("tableName") String tableName);

    /**
     * <p>
     * Description: 更新发送数据
     * </p>
     * 
     * @param tableName 表名
     * @param msgId 消息ID
     * @param smsStatus 消息状态
     * @param smsRetryCount 重试次数
     * @param smsSendTime 发送时间
     * @param smsResponseTime 响应时间
     * @param smsResponseStatus 响应状态
     * @param smsResponseId 响应ID
     * @param updateBy 修改人
     * @param updateDate 修改时间
     */
    void updateSendSmsData(@Param("tableName") String tableName, @Param("msgId") String msgId,
            @Param("smsStatus") String smsStatus, @Param("smsRetryCount") String smsRetryCount,
            @Param("smsSendTime") Date smsSendTime, @Param("smsResponseTime") Date smsResponseTime,
            @Param("smsResponseStatus") String smsResponseStatus, @Param("smsResponseId") String smsResponseId,
            @Param("updateBy") String updateBy, @Param("updateDate") Date updateDate);

    /**
     * <p>
     * Description: 删除数据
     * </p>
     * 
     * @param tableName 表名
     * @param msgId 消息ID
     */
    void deleteSendSmsData(@Param("tableName") String tableName, @Param("msgId") String msgId);

    /**
     * <p>
     * Description: 加载数据
     * </p>
     * 
     * @param tableName 表名
     * @param loadCount 条数
     * @return 结果集
     */
    List<Map<String, Object>> loadSendSmsData(@Param("tableName") String tableName, @Param("loadCount") String loadCount);

    /**
     * <p>
     * Description: 保存消息
     * </p>
     * 
     * @param record 数据
     * @return 操作结果
     */
    int insertSelective(TuSmsSend record);
}
