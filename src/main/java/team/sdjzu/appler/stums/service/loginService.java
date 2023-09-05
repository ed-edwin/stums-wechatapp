package team.sdjzu.appler.stums.service;

/**
 * 登录接口
 */
public interface loginService {
    /**
     * 密码校验
     * @param userId 用户id
     * @param pwd 密码（加密）
     * @return true or false
     */
    public boolean checkPwd(Integer userId,String pwd);

}
