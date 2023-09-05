package team.sdjzu.appler.stums.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sdjzu.appler.stums.mapper.SysUserMapper;
import team.sdjzu.appler.stums.model.dto.SysUserDTO;
import team.sdjzu.appler.stums.service.sysUserService;
import team.sdjzu.appler.stums.utils.AESUtil;

import java.util.List;

/**
 * 从数据库获取用户信息
 */
@Service
public class sysUserServiceImpl implements sysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private AESUtil aesUtil;

    /**
     * 通过当前用户姓名
     * @return 姓名
     */
    @Override
    public String queryUserNameById() {
        Integer id = StpUtil.getLoginIdAsInt();
        return sysUserMapper.queryUserNameById(id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<SysUserDTO> queryList() {
        return sysUserMapper.queryList();
    }

    @Override
    public Integer getNowId() {
        return StpUtil.getLoginIdAsInt();
    }

    @Override
    public void modifyPwd(String newPwd) {
        String ciphertext = aesUtil.AESEncryption(newPwd);
        sysUserMapper.modifyPwd(ciphertext,getNowId());
    }
}
