package team.sdjzu.appler.stums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.sdjzu.appler.stums.model.dto.SysUserDTO;
import team.sdjzu.appler.stums.model.entity.SysUser;

import java.util.List;

/**
 * 用户Mapper
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 查询姓名
     * @param userId userid
     * @return 姓名
     */
    @Select("SELECT DISTINCT " +
            "user_name " +
            "FROM " +
            "sys_user " +
            "WHERE " +
            "user_id = #{userId}")
    public String queryUserNameById(@Param("userId") Integer userId);

    /**
     * 查询名单
     * @return 名单List
     */
    @Select("SELECT user_id,user_name,class_name FROM sys_user;")
    public List<SysUserDTO> queryList();

    /**
     * 修改密码
     * @param newPwd 新密码
     * @param userId userid
     */
    @Update("UPDATE sys_user SET password = #{newPwd} WHERE user_id = #{userId}")
    public void modifyPwd(@Param("newPwd") String newPwd,@Param("userId") Integer userId);
}
