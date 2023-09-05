package team.sdjzu.appler.stums.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户数据
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUser implements Serializable {
    @TableId
    private Integer userId;
    private String userName;
    private String className;
    private String password;
}
