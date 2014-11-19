/**
 * SmsChannelController.java
 * Created at 2014年11月14日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.controller.smschannel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llsfw.core.common.JsonResult;
import com.llsfw.core.controller.base.BaseController;
import com.llsfw.core.security.annotation.CurrentUser;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.service.smschannel.SmsChannelService;

/**
 * <p>
 * ClassName: SmsChannelController
 * </p>
 * <p>
 * Description: 短信通道配置
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月14日
 * </p>
 */
@Controller
@RequestMapping("/smsChannelController")
public class SmsChannelController extends BaseController {

    /**
     * <p>
     * Field scs: 短信通道配置
     * </p>
     */
    @Autowired
    private SmsChannelService scs;

    /**
     * <p>
     * Description: 删除通道
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 操作结果
     */
    @RequiresPermissions("smsChannelController:delete")
    @RequestMapping("deleteChannel")
    @ResponseBody
    public JsonResult<String> deleteChannel(String channelCode) {
        return this.scs.deleteChannel(channelCode);
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
    @RequiresPermissions("smsChannelController:edit")
    @RequestMapping("editSmsChannel")
    @ResponseBody
    public JsonResult<String> editSmsChannel(HttpServletRequest request, String channelCode,
            @CurrentUser String userName) throws Exception {
        return this.scs.editSmsChannel(request.getParameterMap(), channelCode, userName);
    }

    /**
     * <p>
     * Description: 加载通道对象
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 通道对象
     */
    @RequiresPermissions("smsChannelController:edit")
    @RequestMapping("loadChannel")
    @ResponseBody
    public TuSmsChannel loadChannel(String channelCode) {
        return this.scs.loadChannel(channelCode);
    }

    /**
     * <p>
     * Description: 跳转到修改界面
     * </p>
     * 
     * @param channelCode 通道代码
     * @param request 请求对象
     * @return 修改界面
     */
    @RequiresPermissions("smsChannelController:edit")
    @RequestMapping("toSmsChannelEdit")
    public String toSmsChannelEdit(String channelCode, HttpServletRequest request) {
        request.setAttribute("channelCode", channelCode);
        return "usp/smschannel/smsChannelEdit";
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
    @RequiresPermissions("smsChannelController:add")
    @RequestMapping("addSmsChannel")
    @ResponseBody
    public JsonResult<String> addSmsChannel(@CurrentUser String userName, TuSmsChannel tsc) {
        return this.scs.addSmsChannel(userName, tsc);
    }

    /**
     * <p>
     * Description: 校验通道代码唯一性
     * </p>
     * 
     * @param channelCode 通道代码
     * @return 比对结果
     */
    @RequiresPermissions("smsChannelController:add")
    @RequestMapping("channelCodeUniqueCheck")
    @ResponseBody
    public boolean channelCodeUniqueCheck(String channelCode) {
        return this.scs.channelCodeUniqueCheck(channelCode);
    }

    /**
     * <p>
     * Description: 跳转到新增界面
     * </p>
     * 
     * @return 新增界面
     */
    @RequiresPermissions("smsChannelController:add")
    @RequestMapping("toSmsChannelAdd")
    public String toSmsChannelAdd() {
        return "usp/smschannel/smsChannelAdd";
    }

    /**
     * <p>
     * Description: 加载通道列表
     * </p>
     * 
     * @return 通道列表
     */
    @RequiresPermissions("smsChannelController:view")
    @RequestMapping("loadSmsChannel")
    @ResponseBody
    public List<TuSmsChannel> loadSmsChannel() {
        return this.scs.loadSmsChannel();
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
    @RequiresPermissions("smsChannelController:view")
    @RequestMapping("loadChannelSmsCount")
    @ResponseBody
    public JsonResult<String> loadChannelSmsCount(String channelCode) throws Exception {
        return this.scs.loadChannelSmsCount(channelCode);
    }

    /**
     * <p>
     * Description: 初始化方法
     * </p>
     * 
     * @return 主页面
     */
    @RequiresPermissions("smsChannelController:view")
    @RequestMapping("init")
    public String init() {
        return "usp/smschannel/smsChannelMain";
    }
}
