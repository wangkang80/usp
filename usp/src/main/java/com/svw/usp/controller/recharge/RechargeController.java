/**
 * RechargeController.java
 * Created at 2014年10月8日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.controller.recharge;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.llsfw.core.common.Constants;
import com.llsfw.core.common.HttpUtil;
import com.llsfw.core.common.JsonResult;
import com.llsfw.core.common.UUID;
import com.llsfw.core.controller.base.BaseController;
import com.llsfw.core.security.annotation.CurrentUser;
import com.svw.usp.common.SystemParam;
import com.svw.usp.model.standard.TuUserRecharge;
import com.svw.usp.service.recharge.RechargeService;

/**
 * <p>
 * ClassName: RechargeController
 * </p>
 * <p>
 * Description: 账户充值
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年10月8日
 * </p>
 */
@Controller
@RequestMapping("/rechargeController")
public class RechargeController extends BaseController {

    /**
     * <p>
     * Field ras: 账户充值service
     * </p>
     */
    @Autowired
    private RechargeService ras;

    /**
     * <p>
     * Description: 删除单据
     * </p>
     * 
     * @param rechargeCode 单据代码
     * @return 操作结果
     */
    @RequiresPermissions("rechargeController:delete")
    @RequestMapping("deleteRechargeItem")
    @ResponseBody
    public JsonResult<String> deleteRechargeItem(String rechargeCode) {
        return this.ras.deleteRechargeItem(rechargeCode);
    }

    /**
     * <p>
     * Description: 保存单据
     * </p>
     * 
     * @param longinName 用户名
     * @param rechargeCode 单据代码
     * @param rechargeBillingItemData 单据明细
     * @return 操作结果
     */
    @RequiresPermissions("rechargeController:billing")
    @RequestMapping("saveRechargeBilling")
    @ResponseBody
    public JsonResult<String> saveRechargeBilling(@CurrentUser String loginName, String rechargeCode,
            String rechargeBillingItemData) {
        try {
            return this.ras.saveRechargeBilling(loginName, rechargeCode, rechargeBillingItemData);
        } catch (Throwable e) {
            return new JsonResult<String>(Constants.FAIL, "系统忙,请稍后再试");
        }
    }

    /**
     * <p>
     * Description: 初始化方法
     * </p>
     * 
     * @return 主页面
     */
    @RequiresPermissions("rechargeController:billing")
    @RequestMapping("toRechargeBillPage")
    public String toRechargeBillPage(HttpServletRequest request, String rechargeCode) {
        //获得单据主表
        TuUserRecharge r = this.ras.getRecharge(rechargeCode);
        //放入作用域
        request.setAttribute("r", r);
        return "usp/recharge/rechargeBilling";
    }

    /**
     * <p>
     * Description: 保存单据
     * </p>
     * 
     * @param longinName 用户名
     * @param btcPath 凭证路径
     * @param btd 转账时间
     * @param rechargeApplyItemData 单据明细
     * @return 操作结果
     */
    @RequiresPermissions("rechargeController:apply")
    @RequestMapping("saveRechargeApply")
    @ResponseBody
    public JsonResult<String> saveRechargeApply(@CurrentUser String loginName,
            @RequestParam(value = "btc", required = true) CommonsMultipartFile btc,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date btd, String rechargeApplyItemData)
            throws IllegalStateException, IOException {

        //获得必要参数
        String bankTransferCertificatePath = this.ras.getPs().getServerParamter(
                SystemParam.BANK_TRANSFER_CERTIFICATE_PATH.name());

        //整理上传文件的数据
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyyMMdd");

        String realFilePath = null;
        realFilePath = "/" + dateFormat.format(new Date()) + "/";

        String fileId = "F_" + UUID.getUUID(false);

        String fileType = btc.getFileItem().getName()
                .substring(btc.getFileItem().getName().indexOf("."), btc.getFileItem().getName().length());

        String fullPath = null;
        fullPath = bankTransferCertificatePath + realFilePath;
        File f = null;
        f = new File(fullPath);
        f.mkdirs();

        fullPath = bankTransferCertificatePath + realFilePath + fileId + fileType;
        f = new File(fullPath);
        btc.transferTo(f);
        this.log.info("fullPath=" + fullPath);

        //保存数据
        return this.ras.saveRechargeApply(loginName, realFilePath + fileId + fileType, btd, rechargeApplyItemData);
    }

    /**
     * <p>
     * Description: 载入充值清单
     * </p>
     * 
     * @param loginName 当前用户
     * @return 充值清单
     */
    @RequiresPermissions("rechargeController:apply")
    @RequestMapping("loadBePrepaidList")
    @ResponseBody
    public List<Map<String, Object>> loadBePrepaidList(@CurrentUser String loginName) {
        return this.ras.loadBePrepaidList(loginName);
    }

    /**
     * <p>
     * Description: 初始化方法
     * </p>
     * 
     * @return 主页面
     */
    @RequiresPermissions("rechargeController:apply")
    @RequestMapping("toRechargeApplyPage")
    public String toRechargeApplyPage() {
        return "usp/recharge/rechargeApply";
    }

    //---------------------------------------

    @RequiresPermissions("rechargeController:view")
    @RequestMapping(value = "/toRechargeBillPageDownload/{rechargeCode}", method = RequestMethod.GET)
    public void toRechargeBillPageDownload(HttpServletResponse httpServletResponse,
            HttpServletRequest httpServletRequest, @PathVariable String rechargeCode) throws Exception {

        //获得单据主表
        TuUserRecharge r = this.ras.getRecharge(rechargeCode);

        if (r != null) {

            //获得必要参数
            String bankTransferCertificatePath = this.ras.getPs().getServerParamter(
                    SystemParam.BANK_TRANSFER_CERTIFICATE_PATH.name());

            //完整路径
            String filePath = bankTransferCertificatePath + r.getBankTransferCertificate();

            //文件名称
            String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());

            // 获得文件
            File f = null;
            f = new File(filePath);

            //文件是否存在
            if (f.exists()) {

                log.info("文件下载开始:" + filePath);

                //下载
                HttpUtil dlf = null;
                dlf = new HttpUtil();
                dlf.download(httpServletRequest, httpServletResponse, f, fileName);

                log.info("文件下载结束:" + filePath);
            } else {
                throw new Exception("不存在此文件");
            }
        } else {
            throw new Exception("不存在此数据");
        }
    }

    /**
     * <p>
     * Description: 加载单据明细
     * </p>
     * 
     * @param rechargeCode 单据代码
     * @return 单据明细
     */
    @RequiresPermissions("rechargeController:view")
    @RequestMapping("loadRechargeItem")
    @ResponseBody
    public List<Map<String, Object>> loadRechargeItem(String rechargeCode) {
        return this.ras.loadRechargeItem(rechargeCode);
    }

    /**
     * <p>
     * Description: 加载充值单信息
     * </p>
     * 
     * @param userName 当前用户
     * @param page 页数
     * @param rows 行数
     * @return 单据清单
     * @throws Exception 异常
     */
    @RequiresPermissions("rechargeController:view")
    @RequestMapping("loadRecharge")
    @ResponseBody
    public Map<String, Object> loadRecharge(@CurrentUser String userName, int page, int rows) throws Exception {
        return this.ras.loadRecharge(userName, page, rows);
    }

    /**
     * <p>
     * Description: 判断账户是否激活
     * </p>
     * 
     * @param userName 用户名
     * @return 比对结果
     */
    @RequiresPermissions("rechargeController:view")
    @RequestMapping("checkActivate")
    @ResponseBody
    public JsonResult<String> checkActivate(@CurrentUser String userName) {
        return this.ras.checkActivate(userName);
    }

    /**
     * <p>
     * Description: 初始化方法
     * </p>
     * 
     * @return 主页面
     */
    @RequiresPermissions("rechargeController:view")
    @RequestMapping("init")
    public String init() {
        return "usp/recharge/rechargeMain";
    }
}
