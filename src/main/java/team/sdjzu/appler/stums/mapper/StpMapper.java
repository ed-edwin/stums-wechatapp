package team.sdjzu.appler.stums.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 获取角色和权限
 */
@Mapper
public interface StpMapper {

    /**
     * 获取角色
     * @param userId 用户id
     * @return 角色列表
     */
    @Select("SELECT DISTINCT " +
            "sys_role.role " +
            "FROM sys_user " +
            "INNER JOIN sys_role_user ON  sys_user.user_id = sys_role_user.user_id " +
            "INNER JOIN sys_role ON sys_role_user.role_id = sys_role.role_id " +
            "WHERE sys_user.user_id = #{userId}")
    public default List<String> queryRoleById(@Param("userId") Integer userId) {
        return null;
    }

    /**
     * 获取权限
     * @param userId 用户id
     * @return 权限列表
     */
    @Select("SELECT DISTINCT " +
            "sys_menu.code " +
            "FROM " +
            "sys_role_menu " +
            "INNER JOIN sys_menu ON sys_role_menu.menu_id = sys_menu.menu_id " +
            "INNER JOIN sys_user " +
            "INNER JOIN sys_role_user ON sys_user.user_id = sys_role_user.user_id " +
            "AND sys_role_menu.role_id = sys_role_user.role_id " +
            "WHERE " +
            "sys_user.user_id = #{userId}")
    public List<String> queryMenuById(@Param("userId")Integer userId);
}
