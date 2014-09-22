/**
 * MainPageController.java
 * Created at 2014年9月21日
 * Created by kkll
 */
package com.svw.usp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llsfw.core.common.JsonResult;
import com.llsfw.core.controller.base.BaseController;
import com.llsfw.core.security.annotation.CurrentUser;
import com.svw.usp.model.standard.TuUser;
import com.svw.usp.service.MainPageService;

/**
 * <p>
 * ClassName: MainPageController
 * </p>
 * <p>
 * Description: 主页控制
 * </p>
 * <p>
 * Author: kkll
 * </p>
 * <p>
 * Date: 2014年9月21日
 * </p>
 */
@Controller("uspMainController")
@RequestMapping("uspMainController")
public class MainPageController extends BaseController {

    @Autowired
    private MainPageService mps;

    /**
     * <p>
     * Description: 激活账户
     * </p>
     * 
     * @param loginName 用户名
     * @return 操作结果
     */
    @RequestMapping("userInfoActivate")
    @ResponseBody
    public JsonResult<String> userInfoActivate(@CurrentUser String loginName) {
        return this.mps.userInfoActivate(loginName);
    }

    /**
     * <p>
     * Description: 返回用户扩展信息
     * </p>
     * 
     * @param loginName 用户名
     * @return 结果
     */
    @RequestMapping("loadUserInfo")
    @ResponseBody
    public List<TuUser> loadUserInfo(@CurrentUser String loginName) {
        return this.mps.loadUserInfo(loginName);
    }

    /**
     * <p>
     * Description: 跳转到主页
     * </p>
     * 
     * @return 主页
     */
    @RequestMapping("toMain")
    public String toMain() {
        return "usp/main";
    }
}
