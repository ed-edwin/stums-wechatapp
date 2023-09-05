package team.sdjzu.appler.stums.service;

import team.sdjzu.appler.stums.model.dto.SysUserDTO;

import java.util.List;

/**
 * 用户接口
 */
public interface sysUserService {
    public String queryUserNameById();
    public List<SysUserDTO> queryList();
    public Integer getNowId();
    public void modifyPwd(String newPwd);
}
