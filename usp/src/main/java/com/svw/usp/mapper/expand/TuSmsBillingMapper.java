package com.svw.usp.mapper.expand;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.svw.usp.model.expand.TuSmsBilling;

public interface TuSmsBillingMapper {

    /**
     * <p>
     * Description: 更新
     * </p>
     * 
     * @param tableName 表名
     * @param msgId 消息ID
     * @param smsRetryCount 重试次数
     * @param updateBy 修改人
     * @param updateDate 修改时间
     */
    void updateBillingSmsData(@Param("tableName") String tableName, @Param("msgId") String msgId,
            @Param("smsRetryCount") String smsRetryCount, @Param("updateBy") String updateBy,
            @Param("updateDate") Date updateDate);

    /**
     * <p>
     * Description: 删除数据
     * </p>
     * 
     * @param tableName 表名
     * @param msgId 消息ID
     */
    void deleteBillingSmsData(@Param("tableName") String tableName, @Param("msgId") String msgId);

    /**
     * <p>
     * Description: 加载数据
     * </p>
     * 
     * @param tableName 表名
     * @param userName 用户名
     * @param loadCount 条数
     * @return 结果集
     */
    List<Map<String, Object>> loadBillingSmsData(@Param("tableName") String tableName,
            @Param("userName") String userName, @Param("loadCount") String loadCount);

    /**
     * <p>
     * Description: 锁定用户数据,并且返回剩余消息数量
     * </p>
     * 
     * @param userName
     * @return 剩余消息数量
     */
    int lockUserLastSmsCountAndReturn(@Param("userName") String userName);

    /**
     * <p>
     * Description: 查询待结算的用户列表
     * </p>
     * 
     * @param tableName 表名
     * @return 用户列表
     */
    List<String> loadBillingUserList(@Param("tableName") String tableName);

    /**
     * <p>
     * Description: 添加结算消息数据
     * </p>
     * 
     * @param record 数据集
     * @return 操作结果
     */
    int insertSelective(TuSmsBilling record);
}
