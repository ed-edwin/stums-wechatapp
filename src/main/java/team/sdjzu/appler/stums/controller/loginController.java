package team.sdjzu.appler.stums.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.sdjzu.appler.stums.service.impl.loginServiceImpl;

/**
 * 登录相关接口
 */
@RestController
@RequestMapping
public class loginController {

    @Autowired
    private loginServiceImpl loginService;

    // 登录

    @PostMapping("/login")
    public SaResult doLogin(Integer userId, String pwd) {
        // 第一步：比对前端提交的账号名称、密码
        if(loginService.checkPwd(userId,pwd)) {
            // 第二步：根据账号id，进行登录
            StpUtil.login(userId);
            return SaResult.data(StpUtil.getTokenInfo());
        }
        return SaResult.error("登录失败");
    }

    // 查询登录状态

    @GetMapping("/login")
    public SaResult isLogin() {
        return SaResult.ok("登录状态：" + StpUtil.isLogin());
    }

    // 查询 Token 信息

    @GetMapping("/tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销

    @GetMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }


}
