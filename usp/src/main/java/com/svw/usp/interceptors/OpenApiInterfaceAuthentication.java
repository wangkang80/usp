/**
 * OpenApiInterfaceAuthentication.java
 * Created at 2014-07-30
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.interceptors;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.llsfw.core.service.user.UserService;
import com.svw.usp.common.Constants;
import com.svw.usp.common.DesTools;
import com.svw.usp.mapper.standard.TuUserMapper;
import com.svw.usp.model.expand.ResponseVo;
import com.svw.usp.model.standard.TuUser;

/**
 * <p>
 * ClassName: OpenApiInterfaceAuthentication
 * </p>
 * <p>
 * Description: 接口API安全认证
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年7月30日
 * </p>
 */
public class OpenApiInterfaceAuthentication implements HandlerInterceptor {

    /**
     * <p>
     * Field logger: 日志记录
     * </p>
     */
    private final Logger logger = LoggerFactory.getLogger(OpenApiInterfaceAuthentication.class);

    /**
     * <p>
     * Field mps: 主页dao
     * </p>
     */
    @Autowired
    private TuUserMapper tum;

    /**
     * <p>
     * Field us: 用户服务
     * </p>
     */
    @Autowired
    private UserService us;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object object) throws Exception {

        //设定返回值
        boolean rv = true;
        ResponseVo responseVo = null;

        try {

            //从head中获得用户名和密码
            String userName = httpServletRequest.getHeader(Constants.HTTP_REQUEST_HEADER_USERNAME);
            String password = httpServletRequest.getHeader(Constants.HTTP_REQUEST_HEADER_PASSWORD);

            //都必须存在
            if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
                responseVo = new ResponseVo();
                responseVo.setResponseStatus(Constants.SEND_SMS_STATUS_1);
                throw new Exception("用户名或者密码为空");
            }

            //获取数据库中的账号和秘钥
            TuUser user = tum.selectByPrimaryKey(userName);

            //判断是否激活
            if (user == null) {
                responseVo = new ResponseVo();
                responseVo.setResponseStatus(Constants.SEND_SMS_STATUS_2);
                throw new Exception("用户不存在或者未激活");
            }

            //解密密码
            password = DesTools.decrypt(password, user.getInterfaceSecretKey());

            //进行md5密码比对
            boolean result = this.us.pswdCheck(userName, password);

            //判断密码是否正确
            if (!result) {
                responseVo = new ResponseVo();
                responseVo.setResponseStatus(Constants.SEND_SMS_STATUS_3);
                throw new Exception("用户名或者密码错误");
            }

            //校验通过
            rv = true;
        } catch (Throwable e) {

            //如果响应值为空,则填入未知错误
            if (responseVo == null) {
                responseVo = new ResponseVo();
                responseVo.setResponseStatus(Constants.SEND_SMS_STATUS_99999999);
                this.logger.error("未知错误:", e);
            }

            //设置响应时间
            responseVo.setResponseTime(new Date());

            //json转换
            String json = null;
            json = JSON.toJSONString(responseVo);

            //输出
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            OutputStream out = null;
            out = httpServletResponse.getOutputStream();
            PrintWriter pw = null;
            pw = new PrintWriter(
                    new OutputStreamWriter(out, com.llsfw.core.common.Constants.DEF_CHARACTER_SET_ENCODING));
            pw.println(json);
            pw.flush();
            pw.close();
            rv = false;
        }

        return rv;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object object, Exception exception) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }
}
