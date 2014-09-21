/**
 * MainPageController.java
 * Created at 2014年9月21日
 * Created by kkll
 */
package com.svw.usp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llsfw.core.controller.base.BaseController;

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
