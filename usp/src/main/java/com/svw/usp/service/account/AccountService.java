/**
 * AccountService.java
 * Created at 2014年11月14日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.account;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llsfw.core.common.Constants;
import com.llsfw.core.common.JsonResult;
import com.llsfw.core.model.expand.PageResult;
import com.llsfw.core.service.BaseService;
import com.svw.usp.mapper.standard.TuSmsChannelMapper;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.model.standard.TuSmsChannelCriteria;
import com.svw.usp.model.standard.TuUser;

/**
 * <p>
 * ClassName: AccountService
 * </p>
 * <p>
 * Description: 账户维护
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月14日
 * </p>
 */
@Service
public class AccountService extends BaseService {

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
     * Description: 冻结用户
     * </p>
     * 
     * @param loginName 用户名
     * @return 操作结果
     */
    public JsonResult<String> userFreeze(String loginName) {
        this.tum.deleteByPrimaryKey(loginName);
        return new JsonResult<String>(Constants.SUCCESS, null);
    }

    /**
     * <p>
     * Description: 变更用户短信通道
     * </p>
     * 
     * @param currUser 操作人
     * @param loginName 用户名
     * @param channelCode 通道代码
     * @return 操作结果
     */
    public JsonResult<String> changeUserSmsChannel(String currUser, String loginName, String channelCode) {
        //判断是否已经激活
        if (this.tum.selectByPrimaryKey(loginName) == null) {
            return new JsonResult<String>(Constants.FAIL, "用户未激活");
        } else { //添加激活数据
            TuUser tu = new TuUser();
            tu.setUserName(loginName);
            tu.setChannelCode(channelCode);
            tu.setUpdateBy(currUser);
            tu.setUpdateDate(new Date());
            this.tum.updateByPrimaryKeySelective(tu);
            return new JsonResult<String>(Constants.SUCCESS, "变更成功");
        }
    }

    /**
     * <p>
     * Description: 账户激活
     * </p>
     * 
     * @param currUser 操作人
     * @param loginName 用户名
     * @param channelCode 通道代码
     * @return 操作结果
     */
    public JsonResult<String> userActivate(String currUser, String loginName, String channelCode) {
        //判断是否已经激活
        if (this.tum.selectByPrimaryKey(loginName) != null) {
            return new JsonResult<String>(Constants.FAIL, "已经激活");
        } else { //添加激活数据
            TuUser tu = new TuUser();
            tu.setChannelCode(channelCode);
            tu.setCreateBy(currUser);
            tu.setCreateDate(new Date());
            tu.setUserName(loginName);
            this.tum.insertSelective(tu);
            return new JsonResult<String>(Constants.SUCCESS, "激活成功");
        }
    }

    /**
     * <p>
     * Description: 加载通道清单
     * </p>
     * 
     * @return 通道清单
     */
    public List<TuSmsChannel> loadSmsChannelListSearch() {
        List<TuSmsChannel> array = this.tscm.selectByExample(new TuSmsChannelCriteria());
        TuSmsChannel t = new TuSmsChannel();
        t.setChannelCode("");
        t.setChannelName("全部");
        array.add(0, t);
        return array;
    }

    /**
     * <p>
     * Description: 加载通道清单
     * </p>
     * 
     * @return 通道清单
     */
    public List<TuSmsChannel> loadSmsChannelList() {
        return this.tscm.selectByExample(new TuSmsChannelCriteria());
    }

    /**
     * <p>
     * Description: 加载账户清单
     * </p>
     * 
     * @param page 页数
     * @param rows 行数
     * @param loginName 登录名
     * @param userName 用户名
     * @return
     * @throws Exception 异常
     */
    public Map<String, Object> loadAccountList(int page, int rows, String loginName, String userName,
            String userActivateSearch, String smsChannelSearch) throws Exception {
        StringBuffer sql = null;
        sql = new StringBuffer();
        sql.append(" SELECT A.LOGIN_NAME,A.USER_NAME,B.USER_NAME TU_LOGIN_NAME,C.CHANNEL_CODE,CHANNEL_NAME,B.LAST_SMS_COUNT,B.CREATE_BY,B.CREATE_DATE FROM TT_APPLICATION_USER A ");
        sql.append(" LEFT JOIN TU_USER B ON A.LOGIN_NAME=B.USER_NAME ");
        sql.append(" LEFT JOIN TU_SMS_CHANNEL C ON B.CHANNEL_CODE=C.CHANNEL_CODE ");
        sql.append(" WHERE 1=1    ");
        if (!StringUtils.isEmpty(loginName)) {
            sql.append(" AND A.LOGIN_NAME LIKE '%" + loginName + "%'    ");
        }
        if (!StringUtils.isEmpty(userName)) {
            sql.append(" AND A.USER_NAME LIKE '%" + userName + "%'    ");
        }
        if (!StringUtils.isEmpty(userActivateSearch)) {
            if ("1".equals(userActivateSearch)) {
                sql.append(" AND B.USER_NAME IS NOT NULL    ");
            } else if ("2".equals(userActivateSearch)) {
                sql.append(" AND B.USER_NAME IS NULL ");
            }
        }
        if (!StringUtils.isEmpty(smsChannelSearch)) {
            sql.append(" AND C.CHANNEL_CODE='" + smsChannelSearch + "'    ");
        }
        sql.append(" ORDER BY B.CREATE_DATE DESC ");
        PageResult pr = this.getPrs().pageQuery(sql.toString(), rows, page);
        Map<String, Object> rv = new HashMap<String, Object>();
        rv.put("total", pr.getTotalRecords());
        rv.put("rows", pr.getRecords());
        return rv;
    }

}
