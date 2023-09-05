package team.sdjzu.appler.stums.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sdjzu.appler.stums.mapper.loginMapper;
import team.sdjzu.appler.stums.service.loginService;
import team.sdjzu.appler.stums.utils.AESUtil;

/**
 * 登录实现类
 */
@Service
public class loginServiceImpl implements loginService {
    /**
     * 注入相关bean
     */
    @Autowired
    private AESUtil aesUtil;
    @Autowired
    private loginMapper loginMapper;

    /**
     * 密码校验（解密）
     * @param userId 用户id
     * @param pwd 密码（加密）
     * @return true or false
     */
    @Override
    public boolean checkPwd(Integer userId, String pwd) {
        String queriedPwd = loginMapper.queryByUserId(userId);
        String password = aesUtil.AESDecryption(queriedPwd);
        if (password.equals(pwd)){
            return true;
        }
        else return false;
    }
}
