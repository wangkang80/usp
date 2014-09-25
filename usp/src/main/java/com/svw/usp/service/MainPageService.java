/**
 * MainPageService.java
 * Created at 2014年9月22日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llsfw.core.common.Constants;
import com.llsfw.core.common.JsonResult;
import com.llsfw.core.service.BaseService;
import com.svw.usp.common.DesTools;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.model.standard.TuUser;
import com.svw.usp.model.standard.TuUserCriteria;

/**
 * <p>
 * ClassName: MainPageService
 * </p>
 * <p>
 * Description: 主页服务
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月22日
 * </p>
 */
@Service
public class MainPageService extends BaseService {

    /**
     * <p>
     * Field tum: 用户扩展表dao
     * </p>
     */
    @Autowired
    private TuUserMapper tum;

    /**
     * <p>
     * Description: 修改接口秘钥
     * </p>
     * 
     * @param userName 用户名
     * @param interfacePswd 密码
     * @param secretKey 秘钥
     * @return 操作结果
     * @throws Exception 异常
     */
    public JsonResult<String> editSecretKey(String userName, String interfacePswd, String secretKey) throws Exception {

        //判断用户是否存在
        TuUser tu = this.loadTuUser(userName);
        if (tu == null) {
            return new JsonResult<String>(Constants.FAIL, "用户不存在");
        }

        //密码加密
        interfacePswd = DesTools.encrypt(interfacePswd, secretKey);

        //保存
        tu = new TuUser();
        tu.setUserName(userName);
        tu.setInterfaceSecretKey(secretKey);
        tu.setInterfacePassword(interfacePswd);
        tu.setUpdateBy(userName);
        tu.setUpdateDate(new Date());
        this.tum.updateByPrimaryKeySelective(tu);
        return new JsonResult<String>(Constants.SUCCESS, "保存成功");
    }

    /**
     * <p>
     * Description: 加载用户扩展信息
     * </p>
     * 
     * @param loginUser 用户名
     * @return 扩展信息
     */
    public TuUser loadTuUser(String loginUser) {
        return this.tum.selectByPrimaryKey(loginUser);
    }

    /**
     * <p>
     * Description: 激活账户
     * </p>
     * 
     * @param loginName 用户名
     * @return 操作结果
     */
    public JsonResult<String> userInfoActivate(String loginName) {
        //判断是否已经激活
        if (this.tum.selectByPrimaryKey(loginName) != null) {
            return new JsonResult<String>(Constants.FAIL, "已经激活");
        } else { //添加激活数据
            TuUser tu = new TuUser();
            tu.setCreateBy(loginName);
            tu.setCreateDate(new Date());
            tu.setUserName(loginName);
            this.tum.insertSelective(tu);
            return new JsonResult<String>(Constants.SUCCESS, "激活成功");
        }
    }

    /**
     * <p>
     * Description: 返回用户扩展信息
     * </p>
     * 
     * @param loginName 用户名
     * @return 扩展信息
     */
    public List<TuUser> loadUserInfo(String loginName) {
        TuUserCriteria tuc = new TuUserCriteria();
        tuc.createCriteria().andUserNameEqualTo(loginName);
        return this.tum.selectByExample(tuc);
    }
}
