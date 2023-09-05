package team.sdjzu.appler.stums.controller;


import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sdjzu.appler.stums.model.dto.SysUserDTO;
import team.sdjzu.appler.stums.service.impl.loginServiceImpl;
import team.sdjzu.appler.stums.service.impl.sysUserServiceImpl;
import team.sdjzu.appler.stums.utils.passwordUtil;

import java.util.List;

/**
 * 用户设置Controller
 */
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private sysUserServiceImpl sysUserService;
    @Autowired
    private loginServiceImpl loginService;
    @Autowired
    private passwordUtil passwordUtil;

    /**
     * 名单查询
     * @return 名单List
     */
    @GetMapping("/query")
    public List<SysUserDTO> queryList(){
        return sysUserService.queryList();
    }

    /**
     * 修改密码
     * @param originalPwd 原密码
     * @param newPwd 新密码
     */
    @PostMapping("/password")
    public SaResult modifyPwd(String originalPwd,String newPwd){
        if (!loginService.checkPwd(sysUserService.getNowId(),originalPwd)){
            return SaResult.error("原密码错误");
        }
        else if (!passwordUtil.isPasswordLengthValid(newPwd)){
            return SaResult.error("请输入一个8-16位的密码");
        }
        else if (!passwordUtil.isPasswordValid(newPwd)) {
            return SaResult.error("请输入正确格式的密码");
        }
        else{
            sysUserService.modifyPwd(newPwd);
            return SaResult.ok();
        }
    }
}
