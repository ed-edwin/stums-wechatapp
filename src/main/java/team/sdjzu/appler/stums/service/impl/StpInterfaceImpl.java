package team.sdjzu.appler.stums.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sdjzu.appler.stums.mapper.StpMapper;

import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Service    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private StpMapper stpMapper;
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        //Object转Integer
        Integer id = Integer.parseInt(loginId.toString());

        return stpMapper.queryMenuById(id);
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        //Object转Integer
        Integer id = Integer.parseInt(loginId.toString());

        return stpMapper.queryRoleById(id);
    }

}
