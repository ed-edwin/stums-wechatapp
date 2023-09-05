package team.sdjzu.appler.stums.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 无密码的SysUser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUserDTO implements Serializable {
    private Integer userId;
    private String userName;
    private String className;
}
