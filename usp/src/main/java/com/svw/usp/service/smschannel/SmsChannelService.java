/**
 * SmsChannelService.java
 * Created at 2014年11月14日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.smschannel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llsfw.core.common.AutoLoadBean;
import com.llsfw.core.common.Constants;
import com.llsfw.core.common.JsonResult;
import com.llsfw.core.service.BaseService;
import com.svw.usp.common.DesTools;
import com.svw.usp.common.DkfSmsClient;
import com.svw.usp.mapper.standard.TuSmsChannelMapper;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.model.standard.TuSmsChannelCriteria;
import com.svw.usp.model.standard.TuUserCriteria;

/**
 * <p>
 * ClassName: SmsChannelService
 * </p>
 * <p>
 * Description: 短信通道
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月14日
 * </p>
 */
@Service
public class SmsChannelService extends BaseService {

    /**
     * <p>
     * Field tscm: 短信通道dao
     * </p>
     */
    @Autowired
    private TuSmsChannelMapper tscm;

    /**
     * <p>
     * Field tum: 用户dao
     * </p>
     */
    @Autowired
    private TuUserMapper tum;

    /**
     * <p>
     * Description: 删除通道
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 操作结果
     */
    public JsonResult<String> deleteChannel(String channelCode) {
        TuUserCriteria tuc = new TuUserCriteria();
        tuc.createCriteria().andChannelCodeEqualTo(channelCode);
        if (this.tum.countByExample(tuc) > 0) {
            return new JsonResult<String>(Constants.FAIL, "有用户关联此通道,无法删除");
        } else {
            this.tscm.deleteByPrimaryKey(channelCode);
            return new JsonResult<String>(Constants.SUCCESS, null);
        }
    }

    /**
     * <p>
     * Description: 更新通道数据
     * </p>
     * 
     * @param request 请求对象
     * @param channelCode 通道代码
     * @param userName 用户名
     * @return 操作结果
     * @throws Exception 异常
     */
    public JsonResult<String> editSmsChannel(Map<String, String[]> valueMap, String channelCode, String userName)
            throws Exception {
        TuSmsChannel tsc = this.tscm.selectByPrimaryKey(channelCode);
        tsc = AutoLoadBean.load(tsc, valueMap);
        tsc.setUpdateBy(userName);
        tsc.setUpdateDate(new Date());
        this.tscm.updateByPrimaryKey(tsc);
        return new JsonResult<String>(Constants.SUCCESS, null);
    }

    /**
     * <p>
     * Description: 加载通道对象
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 通道对象
     */
    public TuSmsChannel loadChannel(String channelCode) {
        return this.tscm.selectByPrimaryKey(channelCode);
    }

    /**
     * <p>
     * Description: 保存通道
     * </p>
     * 
     * @param userName 用户名
     * @param tsc 通道信息
     * @return 操作结果
     */
    public JsonResult<String> addSmsChannel(String userName, TuSmsChannel tsc) {
        tsc.setCreateBy(userName);
        tsc.setCreateDate(new Date());
        this.tscm.insert(tsc);
        return new JsonResult<String>(Constants.SUCCESS, null);
    }

    /**
     * <p>
     * Description: 校验通道代码唯一性
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 比对结果
     */
    public boolean channelCodeUniqueCheck(String channelCode) {
        TuSmsChannelCriteria tscc = new TuSmsChannelCriteria();
        tscc.createCriteria().andChannelCodeEqualTo(channelCode);
        return this.tscm.countByExample(tscc) > 0 ? false : true;
    }

    /**
     * <p>
     * Description: 加载通道列表
     * </p>
     * 
     * @return 通道列表
     */
    public List<TuSmsChannel> loadSmsChannel() {
        TuSmsChannelCriteria tscc = new TuSmsChannelCriteria();
        tscc.setOrderByClause(" create_date desc ");
        return this.tscm.selectByExample(tscc);
    }

    /**
     * <p>
     * Description: 返回通道剩余短信数量
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 剩余短信数量
     * @throws Exception 异常
     */
    public JsonResult<String> loadChannelSmsCount(String channelCode) throws Exception {
        //获得通道配置对象
        TuSmsChannel tsc = this.tscm.selectByPrimaryKey(channelCode);
        String dkfWebserviceUrl = tsc.getChannelHost();
        String dkfWebserviceUserName = tsc.getChannelUserName();
        String dkfWebservicePassword = tsc.getChannelPassword();
        String dkfWebserviceSecretKey = tsc.getChannelSecretKey();

        //加密用户名和密码
        dkfWebserviceUserName = DesTools.encrypt(dkfWebserviceUserName, dkfWebserviceSecretKey);
        dkfWebservicePassword = DesTools.encrypt(dkfWebservicePassword, dkfWebserviceSecretKey);

        //初始化短信发送服务
        DkfSmsClient client = new DkfSmsClient(dkfWebserviceUrl, dkfWebserviceUserName, dkfWebservicePassword,
                dkfWebserviceSecretKey);

        //查询剩余短信数量
        String result = client.getUserSmsCount(dkfWebserviceUserName, dkfWebservicePassword);

        //返回
        return new JsonResult<String>(Constants.SUCCESS, result);
    }

}
