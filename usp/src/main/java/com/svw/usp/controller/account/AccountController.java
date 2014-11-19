/**
 * AccountController.java
 * Created at 2014年11月14日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.controller.account;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llsfw.core.common.JsonResult;
import com.llsfw.core.controller.base.BaseController;
import com.llsfw.core.security.annotation.CurrentUser;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.service.account.AccountService;

/**
 * <p>
 * ClassName: AccountController
 * </p>
 * <p>
 * Description: 账户管理
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月14日
 * </p>
 */
@Controller
@RequestMapping("/accountController")
public class AccountController extends BaseController {

    /**
     * <p>
     * Field as: 账户服务
     * </p>
     */
    @Autowired
    private AccountService as;

    /**
     * <p>
     * Description: 冻结用户
     * </p>
     * 
     * @param loginName 用户名
     * @return 操作结果
     */
    @RequiresPermissions("accountController:freeze")
    @RequestMapping("userFreeze")
    @ResponseBody
    public JsonResult<String> userFreeze(String loginName) {
        return this.as.userFreeze(loginName);
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
    @RequiresPermissions("accountController:changeSmsChannel")
    @RequestMapping("changeUserSmsChannel")
    @ResponseBody
    public JsonResult<String> changeUserSmsChannel(@CurrentUser String currUser, String loginName, String channelCode) {
        return this.as.changeUserSmsChannel(currUser, loginName, channelCode);
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
    @RequiresPermissions("accountController:activate")
    @RequestMapping("userActivate")
    @ResponseBody
    public JsonResult<String> userActivate(@CurrentUser String currUser, String loginName, String channelCode) {
        return this.as.userActivate(currUser, loginName, channelCode);
    }

    /**
     * <p>
     * Description: 加载通道清单
     * </p>
     * 
     * @return 通道清单
     */
    @RequiresPermissions("accountController:view")
    @RequestMapping("loadSmsChannelList")
    @ResponseBody
    public List<TuSmsChannel> loadSmsChannelList() {
        return this.as.loadSmsChannelList();
    }

    /**
     * <p>
     * Description: 加载通道清单
     * </p>
     * 
     * @return 通道清单
     */
    @RequiresPermissions("accountController:view")
    @RequestMapping("loadSmsChannelListSearch")
    @ResponseBody
    public List<TuSmsChannel> loadSmsChannelListSearch() {
        return this.as.loadSmsChannelListSearch();
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
    @RequiresPermissions("accountController:view")
    @RequestMapping("loadAccountList")
    @ResponseBody
    public Map<String, Object> loadAccountList(int page, int rows, String loginName, String userName,
            String userActivateSearch, String smsChannelSearch) throws Exception {
        return this.as.loadAccountList(page, rows, loginName, userName, userActivateSearch, smsChannelSearch);
    }

    /**
     * <p>
     * Description: 初始化方法
     * </p>
     * 
     * @return 主页面
     */
    @RequiresPermissions("accountController:view")
    @RequestMapping("init")
    public String init() {
        return "usp/account/accountMain";
    }

}
