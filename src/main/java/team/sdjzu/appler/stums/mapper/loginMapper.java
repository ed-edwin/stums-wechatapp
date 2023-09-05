package team.sdjzu.appler.stums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import team.sdjzu.appler.stums.model.entity.SysUser;

/**
 * 登录
 */
@Mapper
public interface loginMapper extends BaseMapper<SysUser> {

    /**
     * 从sys_user中通过id匹配密码
     */
    @Select("SELECT sys_user.password FROM sys_user WHERE sys_user.user_id = #{userId}")
    public String queryByUserId(@Param("userId") Integer userId);
}
