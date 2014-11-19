/**
 * RechargeService.java
 * Created at 2014年10月8日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.recharge;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.llsfw.core.common.Constants;
import com.llsfw.core.common.JsonResult;
import com.llsfw.core.common.UUID;
import com.llsfw.core.mapper.standard.TtApplicationUserMapper;
import com.llsfw.core.mapper.standard.TtJobMapper;
import com.llsfw.core.mapper.standard.TtOrganizationMapper;
import com.llsfw.core.mapper.standard.TtUserJobMapper;
import com.llsfw.core.model.expand.PageResult;
import com.llsfw.core.model.standard.TtApplicationUser;
import com.llsfw.core.model.standard.TtJob;
import com.llsfw.core.model.standard.TtOrganization;
import com.llsfw.core.model.standard.TtOrganizationCriteria;
import com.llsfw.core.model.standard.TtUserJob;
import com.llsfw.core.model.standard.TtUserJobCriteria;
import com.llsfw.core.service.BaseService;
import com.svw.usp.common.SystemParam;
import com.svw.usp.mapper.expand.TuSmsBillingMapper;
import com.svw.usp.mapper.standard.TuSmsChannelMapper;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.mapper.standard.TuUserRechargeItemMapper;
import com.svw.usp.mapper.standard.TuUserRechargeMapper;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.model.standard.TuUser;
import com.svw.usp.model.standard.TuUserRecharge;
import com.svw.usp.model.standard.TuUserRechargeItem;
import com.svw.usp.model.standard.TuUserRechargeItemCriteria;

/**
 * <p>
 * ClassName: RechargeService
 * </p>
 * <p>
 * Description: 账户充值服务
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年10月8日
 * </p>
 */
@Service
public class RechargeService extends BaseService {

    /**
     * <p>
     * Field RECHARGE_BILL_PERMITTED: 结算权限字符串
     * </p>
     */
    public static final String RECHARGE_BILL_PERMITTED = "rechargeController:billing";

    /**
     * <p>
     * Field tum: 用户扩展dao
     * </p>
     */
    @Autowired
    private TuUserMapper tum;

    /**
     * <p>
     * Field taum: 用户dao
     * </p>
     */
    @Autowired
    private TtApplicationUserMapper taum;

    /**
     * <p>
     * Field turim: 充值单明细dao
     * </p>
     */
    @Autowired
    private TuUserRechargeItemMapper turim;

    /**
     * <p>
     * Field turm: 充值单dao
     * </p>
     */
    @Autowired
    private TuUserRechargeMapper turm;

    /**
     * <p>
     * Field tujm: 用户岗位dao
     * </p>
     */
    @Autowired
    private TtUserJobMapper tujm;

    /**
     * <p>
     * Field tjm: 岗位dao
     * </p>
     */
    @Autowired
    private TtJobMapper tjm;

    /**
     * <p>
     * Field tom: 组织机构dao
     * </p>
     */
    @Autowired
    private TtOrganizationMapper tom;

    /**
     * <p>
     * Field tsbm: 结算dao
     * </p>
     */
    @Autowired
    private TuSmsBillingMapper tsbm;

    /**
     * <p>
     * Field tscm: 短信通道dao
     * </p>
     */
    @Autowired
    private TuSmsChannelMapper tscm;

    /**
     * <p>
     * Description: 返回充值单据
     * </p>
     * 
     * @param rechargeCode 单据代码
     * @return 单据
     */
    public TuUserRecharge getRecharge(String rechargeCode) {
        return this.turm.selectByPrimaryKey(rechargeCode);
    }

    /**
     * <p>
     * Description: 删除单据
     * </p>
     * 
     * @param rechargeCode 单据代码
     * @return 操作结果
     */
    public JsonResult<String> deleteRechargeItem(String rechargeCode) {

        //获得必要参数
        String bankTransferCertificatePath = this.getPs().getServerParamter(
                SystemParam.BANK_TRANSFER_CERTIFICATE_PATH.name());

        TuUserRechargeItemCriteria turic = new TuUserRechargeItemCriteria();
        turic.createCriteria().andRechargeCodeEqualTo(rechargeCode);
        this.turim.deleteByExample(turic);

        //获得主表数据
        TuUserRecharge tur = this.turm.selectByPrimaryKey(rechargeCode);

        //删除凭据
        this.log.info("删除:" + new File(bankTransferCertificatePath + tur.getBankTransferCertificate()).delete());

        //判断目录下是否还存在文件,如果不存在,则删除
        boolean delDir = false;
        String dirPath = bankTransferCertificatePath
                + tur.getBankTransferCertificate().substring(0, tur.getBankTransferCertificate().lastIndexOf("/") + 1);
        File f = null;
        f = new File(dirPath);
        if (ArrayUtils.isEmpty(f.list())) {
            delDir = f.delete();
        }
        this.log.info(f.getPath() + "删除:" + delDir);

        //删除主表数据
        this.turm.deleteByPrimaryKey(rechargeCode);
        return new JsonResult<String>(Constants.SUCCESS, "删除成功");
    }

    public JsonResult<String> saveRechargeBilling(String loginName, String rechargeCode, String rechargeBillingItemData) {

        //解析明细数据
        List<Map<String, Object>> rechargeBillItemList = JSON.parseObject(rechargeBillingItemData,
                new TypeReference<List<Map<String, Object>>>() {
                });

        //统一时间
        Date date = new Date();

        //获得当前单据,更新主单数据
        TuUserRecharge tur = new TuUserRecharge();
        tur.setRechargeCheckMan(loginName);
        tur.setRechargeCheckTime(date);
        tur.setRechargeCode(rechargeCode);
        tur.setRechargeStatus(com.svw.usp.common.Constants.STATUS_2);
        tur.setUpdateBy(loginName);
        tur.setUpdateDate(date);
        this.turm.updateByPrimaryKeySelective(tur);

        //更新明细
        if (!CollectionUtils.isEmpty(rechargeBillItemList)) {
            for (Map<String, Object> item : rechargeBillItemList) {

                //获得数据
                String bePrepaid = item.get("BE_PREPAID").toString();
                String smsPlanCount = item.get("SMS_PLAN_COUNT").toString();
                Object smsRealCount = item.get("SMS_REAL_COUNT");
                String smsTotalPrice = item.get("SMS_TOTAL_PRICE").toString();
                String smsUnitPrice = item.get("SMS_UNIT_PRICE").toString();

                //更新充值单明细数据
                TuUserRechargeItem rechargeItem = new TuUserRechargeItem();
                rechargeItem.setBePrepaid(bePrepaid);
                rechargeItem.setRechargeCode(rechargeCode);
                rechargeItem.setRechargeStatus(com.svw.usp.common.Constants.STATUS_2);
                rechargeItem.setSmsPlanCount(new Integer(smsPlanCount));
                rechargeItem.setSmsRechargeDate(date);
                rechargeItem.setSmsTotalPrice(new BigDecimal(smsTotalPrice));
                rechargeItem.setSmsUnitPrice(new BigDecimal(smsUnitPrice));
                rechargeItem.setUpdateBy(loginName);
                rechargeItem.setUpdateDate(date);

                //锁定用户,剩余短信条数
                Integer lastSmsCount = new Integer(this.tsbm.lockUserLastSmsCountAndReturn(bePrepaid));

                //计算用户剩余短信条数
                rechargeItem.setSmsBforeCount(lastSmsCount);
                if (smsRealCount != null) {
                    rechargeItem.setSmsRealCount(new Integer(smsRealCount.toString()));
                    lastSmsCount = lastSmsCount + new Integer(smsRealCount.toString());
                } else {
                    rechargeItem.setSmsRealCount(new Integer(smsPlanCount));
                    lastSmsCount = lastSmsCount + new Integer(smsPlanCount);
                }
                rechargeItem.setSmsAfterCount(lastSmsCount);

                //更新充值单明细
                this.turim.updateByPrimaryKeySelective(rechargeItem);

                //更新用户剩余短信数量
                TuUser user = new TuUser();
                user.setUserName(bePrepaid);
                user.setLastSmsCount(lastSmsCount);
                user.setUpdateBy(loginName);
                user.setUpdateDate(date);
                this.tum.updateByPrimaryKeySelective(user);
            }
        }

        //返回
        return new JsonResult<String>(Constants.SUCCESS, "充值成功");
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
    public JsonResult<String> saveRechargeApply(String longinName, String btcPath, Date btd,
            String rechargeApplyItemData) {

        JsonResult<String> rv = null;

        //生成交易代码
        String rechargeCode = UUID.getUUID(false);

        //解析明细数据
        List<Map<String, Object>> rechargeApplyItemList = JSON.parseObject(rechargeApplyItemData,
                new TypeReference<List<Map<String, Object>>>() {
                });

        //填充主表数据
        TuUserRecharge tur = new TuUserRecharge();
        tur.setBankTransferCertificate(btcPath);
        tur.setBankTransferDate(btd);
        tur.setCreateBy(longinName);
        tur.setCreateDate(new Date());
        //tur.setRechargeCheckMan();
        //tur.setRechargeCheckTime(rechargeCheckTime);
        tur.setRechargeCode(rechargeCode);
        tur.setRechargeMan(longinName);
        tur.setRechargeStatus(com.svw.usp.common.Constants.STATUS_1);
        //tur.setUpdateBy(updateBy);
        //tur.setUpdateDate(updateDate);

        //填充从表数据
        boolean hasItem = false;
        if (!CollectionUtils.isEmpty(rechargeApplyItemList)) {
            for (Map<String, Object> item : rechargeApplyItemList) {
                String bePrepaid = item.get("LOGIN_NAME").toString();
                String smsPlanCount = item.get("SMS_PLAN_COUNT").toString();
                String smsTotalPrice = item.get("SMS_TOTAL_PRICE").toString();
                String smsUnitPrice = item.get("SMS_UNIT_PRICE").toString();

                //如果金额是0,则不保存
                if (Integer.parseInt(smsTotalPrice) > 0) {
                    TuUserRechargeItem rechargeItem = new TuUserRechargeItem();
                    rechargeItem.setBePrepaid(bePrepaid);
                    rechargeItem.setCreateBy(longinName);
                    rechargeItem.setCreateDate(new Date());
                    rechargeItem.setRechargeCode(rechargeCode);
                    rechargeItem.setRechargeStatus(com.svw.usp.common.Constants.STATUS_1);
                    //rechargeItem.setSmsAfterCount(smsAfterCount);
                    //rechargeItem.setSmsBforeCount(smsBforeCount);
                    rechargeItem.setSmsPlanCount(new Integer(smsPlanCount));
                    //rechargeItem.setSmsRealCount(smsRealCount);
                    //rechargeItem.setSmsRechargeDate(smsRechargeDate);
                    rechargeItem.setSmsTotalPrice(new BigDecimal(smsTotalPrice));
                    rechargeItem.setSmsUnitPrice(new BigDecimal(smsUnitPrice));
                    //rechargeItem.setUpdateBy(updateBy);
                    //rechargeItem.setUpdateDate(updateDate);
                    this.turim.insertSelective(rechargeItem);
                    hasItem = true;
                }
            }
        }

        //是否有明细项保存
        if (hasItem) {
            this.turm.insertSelective(tur);
            rv = new JsonResult<String>(Constants.SUCCESS, "提交成功");
        } else {
            rv = new JsonResult<String>(Constants.FAIL, "充值单无明细项");
        }

        //返回
        return rv;
    }

    /**
     * <p>
     * Description: 载入充值清单
     * </p>
     * 
     * @param loginName 当前用户
     * @return 充值清单
     */
    public List<Map<String, Object>> loadBePrepaidList(String loginName) {
        List<Map<String, Object>> rv = new ArrayList<Map<String, Object>>();

        //首先载入自己
        TtApplicationUser user = this.taum.selectByPrimaryKey(loginName);
        TuUser u = this.tum.selectByPrimaryKey(loginName);
        TuSmsChannel tsc = this.tscm.selectByPrimaryKey(u.getChannelCode());
        Map<String, Object> self = new HashMap<>();
        self.put("LOGIN_NAME", loginName);
        self.put("BE_PREPAID_NAME", user.getUserName());
        self.put("SMS_UNIT_PRICE", tsc.getChannelPrice());
        self.put("SMS_TOTAL_PRICE", 0);
        self.put("SMS_PLAN_COUNT", 0);
        self.put("CURR_SMS_COUNT", u.getLastSmsCount());
        rv.add(self);

        //载入同级机构用户
        String orgCodeList = "";
        TtUserJobCriteria tujc = new TtUserJobCriteria();
        tujc.createCriteria().andLoginNameEqualTo(loginName);
        List<TtUserJob> jobList = this.tujm.selectByExample(tujc);
        if (!CollectionUtils.isEmpty(jobList)) {
            for (TtUserJob userJob : jobList) {
                TtJob job = this.tjm.selectByPrimaryKey(userJob.getJobCode());
                orgCodeList += "'" + job.getOrgCode() + "',";
                orgCodeList = this.getOrgCode(job.getOrgCode(), orgCodeList);
            }
        }

        //如果有组织,则继续
        if (!StringUtils.isEmpty(orgCodeList)) {
            orgCodeList = orgCodeList.substring(0, orgCodeList.length() - 1); //去除多余的逗号
            StringBuffer sb = new StringBuffer();
            sb.append(" SELECT A.LOGIN_NAME,A.USER_NAME FROM TT_APPLICATION_USER A,TT_USER_JOB B,TT_JOB C,TT_ORGANIZATION D,TU_USER E ");
            sb.append(" WHERE A.LOGIN_NAME=B.LOGIN_NAME AND B.JOB_CODE=C.JOB_CODE AND C.ORG_CODE=D.ORG_CODE AND A.LOGIN_NAME=E.USER_NAME ");
            sb.append(" AND D.ORG_CODE IN (" + orgCodeList + ") ");
            sb.append(" GROUP BY A.LOGIN_NAME,A.USER_NAME ");
            List<Map<String, Object>> userList = this.getImqm().queryMap(sb.toString());
            if (!CollectionUtils.isEmpty(userList)) {
                for (Map<String, Object> userItem : userList) {
                    String itemLoginName = userItem.get("LOGIN_NAME").toString();
                    String itemUserName = userItem.get("USER_NAME").toString();
                    if (itemLoginName.equals(loginName)) {
                        continue;
                    }
                    TuUser tu = this.tum.selectByPrimaryKey(itemLoginName);
                    TuSmsChannel tscs = this.tscm.selectByPrimaryKey(tu.getChannelCode());
                    Map<String, Object> item = new HashMap<>();
                    item.put("LOGIN_NAME", itemLoginName);
                    item.put("BE_PREPAID_NAME", itemUserName);
                    item.put("SMS_UNIT_PRICE", tscs.getChannelPrice());
                    item.put("SMS_TOTAL_PRICE", 0);
                    item.put("SMS_PLAN_COUNT", 0);
                    item.put("CURR_SMS_COUNT", tu.getLastSmsCount());
                    rv.add(item);
                }
            }
        }
        return rv;
    }

    /**
     * <p>
     * Description: 递归找寻下级组织
     * </p>
     * 
     * @param orgCode 组织代码
     * @param orgCodeList 组织代码清单
     * @return 结果
     */
    private String getOrgCode(String orgCode, String orgCodeList) {
        TtOrganizationCriteria toc = new TtOrganizationCriteria();
        toc.createCriteria().andParentOrgCodeEqualTo(orgCode);
        List<TtOrganization> toList = this.tom.selectByExample(toc);
        if (!CollectionUtils.isEmpty(toList)) {
            for (TtOrganization to : toList) {
                orgCodeList += "'" + to.getOrgCode() + "',";
                orgCodeList = this.getOrgCode(to.getOrgCode(), orgCodeList);
            }
        }
        return orgCodeList;
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
    public Map<String, Object> loadRecharge(String userName, int page, int rows) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT  ");
        sb.append(" A.RECHARGE_CODE, ");
        sb.append(" A.RECHARGE_MAN ,  ");
        sb.append(" B.USER_NAME, ");
        sb.append(" ( ");
        sb.append("     SELECT AA.ORG_NAME FROM TT_ORGANIZATION AA , TT_JOB BB , TT_USER_JOB CC ");
        sb.append("     WHERE AA.ORG_CODE=BB.ORG_CODE AND BB.JOB_CODE=CC.JOB_CODE ");
        sb.append("     AND CC.LOGIN_NAME=B.LOGIN_NAME ");
        sb.append("     LIMIT 1 ");
        sb.append(" ) RECHARGE_MAN_ORG, ");
        sb.append(" A.BANK_TRANSFER_DATE, ");
        sb.append(" A.BANK_TRANSFER_CERTIFICATE, ");
        sb.append(" A.RECHARGE_STATUS, ");
        sb.append(" C.SMS_TOTAL_PRICE, ");
        sb.append(" C.SMS_PLAN_COUNT, ");
        sb.append(" C.SMS_REAL_COUNT, ");
        sb.append(" A.RECHARGE_CHECK_MAN, ");
        sb.append(" A.RECHARGE_CHECK_TIME, ");
        sb.append(" A.CREATE_BY, ");
        sb.append(" A.CREATE_DATE, ");
        sb.append(" A.UPDATE_BY, ");
        sb.append(" A.UPDATE_DATE ");
        sb.append(" FROM TU_USER_RECHARGE A ");
        sb.append(" LEFT JOIN  TT_APPLICATION_USER B ON A.RECHARGE_MAN=B.LOGIN_NAME ");
        sb.append(" LEFT JOIN ( ");
        sb.append("     SELECT  ");
        sb.append("     CC.RECHARGE_CODE, ");
        sb.append("     SUM(CC.SMS_TOTAL_PRICE) SMS_TOTAL_PRICE, ");
        sb.append("     SUM(CC.SMS_PLAN_COUNT) SMS_PLAN_COUNT, ");
        sb.append("     SUM(CC.SMS_REAL_COUNT) SMS_REAL_COUNT ");
        sb.append("     FROM TU_USER_RECHARGE_ITEM CC GROUP BY CC.RECHARGE_CODE ");
        sb.append(" ) C ON A.RECHARGE_CODE=C.RECHARGE_CODE ");
        sb.append(" WHERE 1=1 ");
        //如果没有结算权限,则只能查询自己创建的充值单
        if (!subject.isPermitted(RECHARGE_BILL_PERMITTED)) {
            sb.append(" AND A.RECHARGE_MAN='" + userName + "' ");
            this.log.info("----- NOT HAS " + RECHARGE_BILL_PERMITTED);
        }
        sb.append(" ORDER BY A.CREATE_DATE DESC ");
        PageResult pr = this.getPrs().pageQuery(sb.toString(), rows, page);
        Map<String, Object> rv = new HashMap<String, Object>();
        rv.put("total", pr.getTotalRecords());
        rv.put("rows", pr.getRecords());
        return rv;
    }

    /**
     * <p>
     * Description: 加载单据明细
     * </p>
     * 
     * @param rechargeCode 单据代码
     * @return 单据明细
     */
    public List<Map<String, Object>> loadRechargeItem(String rechargeCode) {
        if (!StringUtils.isEmpty(rechargeCode)) {
            StringBuffer sb = new StringBuffer();
            sb.append(" SELECT A.*,B.USER_NAME BE_PREPAID_NAME FROM TU_USER_RECHARGE_ITEM A ");
            sb.append(" LEFT JOIN  TT_APPLICATION_USER B ON A.BE_PREPAID=B.LOGIN_NAME ");
            sb.append(" WHERE A.RECHARGE_CODE='" + rechargeCode + "' ");
            sb.append(" ORDER BY A.CREATE_DATE DESC ");
            return this.getImqm().queryMap(sb.toString());
        } else {
            return new ArrayList<Map<String, Object>>();
        }
    }

    /**
     * <p>
     * Description: 判断账户是否激活
     * </p>
     * 
     * @param userName 用户名
     * @return 比对结果
     */
    public JsonResult<String> checkActivate(String userName) {
        if (this.tum.selectByPrimaryKey(userName) == null) {
            return new JsonResult<String>(Constants.SUCCESS, null);
        }
        return new JsonResult<String>(Constants.FAIL, "账户未激活,请前往主页激活");
    }
}
