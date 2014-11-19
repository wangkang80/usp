/**
 * DkfService.java
 * Created at 2014年11月19日
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.service.openapianon;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llsfw.core.common.UUID;
import com.llsfw.core.service.BaseService;
import com.svw.usp.common.DesTools;
import com.svw.usp.mapper.standard.TuSmsChannelMapper;
import com.svw.usp.mapper.standard.TuSmsReceiveMapper;
import com.svw.usp.model.standard.TuSmsChannel;
import com.svw.usp.model.standard.TuSmsReceive;

/**
 * <p>
 * ClassName: DkfService
 * </p>
 * <p>
 * Description: 上行消息接收服务
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年11月19日
 * </p>
 */
@Service
public class DkfService extends BaseService {

    /**
     * <p>
     * Field tscm: 通道dao
     * </p>
     */
    @Autowired
    private TuSmsChannelMapper tscm;

    public static void main(String[] arge) throws Exception {
        System.out.println(DesTools.decrypt("D1F5403B8D38D96FF2FC34FDF3F7D3E3", "C9eLew123456"));
    }

    /**
     * <p>
     * Field tsrm: 上行消息dao
     * </p>
     */
    @Autowired
    private TuSmsReceiveMapper tsrm;

    /**
     * <p>
     * Description: 接收上行短信
     * </p>
     * 
     * @param channelcode 通道代码
     * @param receiver 用户名
     * @param pswd 密码
     * @param mobile 电话
     * @param content 内容
     * @param motime 时间
     * @return 状态码
     * @throws Exception 异常
     */
    public String receive(String channelcode, String receiver, String pswd, String mobile, String content, String motime)
            throws Exception {

        //日志输出
        this.log.info("channelcode:" + channelcode);
        this.log.info("receiver:" + receiver);
        this.log.info("pswd:" + pswd);
        this.log.info("mobile:" + mobile);
        this.log.info("content:" + content);
        this.log.info("motime:" + motime);

        //设定返回值
        String rv = "200k";

        //必要参数校验
        if (!StringUtils.isEmpty(mobile) && !StringUtils.isEmpty(content)) {

            //获取通道对象,必须存在
            TuSmsChannel tsc = this.tscm.selectByPrimaryKey(channelcode);
            if (null != tsc) {

                //获得秘钥
                String secretKey = tsc.getChannelSecretKey();
                if (!StringUtils.isEmpty(secretKey)) {

                    //解密用户名,密码,短信内容
                    receiver = DesTools.decrypt(receiver, secretKey);
                    pswd = DesTools.decrypt(pswd, secretKey);
                    content = DesTools.decrypt(content, secretKey);

                    //格式化时间
                    Date motimeDate = null;
                    if (!StringUtils.isEmpty(motime)) {
                        motimeDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(motime);
                    }

                    //存储
                    TuSmsReceive tsr = new TuSmsReceive();
                    tsr.setSmsChannelCode(channelcode);
                    tsr.setSmsChannelPassword(pswd);
                    tsr.setSmsChannelUsername(receiver);
                    tsr.setSmsContent(content);
                    tsr.setSmsMobile(mobile);
                    tsr.setSmsMsgId(UUID.getUUID(false));
                    tsr.setSmsReceiveTimePt(new Date());
                    tsr.setSmsReceiveTimeYys(motimeDate);
                    tsrm.insertSelective(tsr);

                } else {
                    rv = "秘钥不存在";
                }
            } else {
                rv = "通道不存在";
            }
        } else {
            rv = "缺少必要参数mobile或者content";
        }

        //返回
        this.log.info("rv:" + rv);
        return rv;
    }
}
