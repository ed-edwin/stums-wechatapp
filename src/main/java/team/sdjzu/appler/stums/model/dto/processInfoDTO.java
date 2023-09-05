package team.sdjzu.appler.stums.model.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 流程信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("process_info")
public class processInfoDTO {
    private Integer infoId;
    private Integer userId;
    private String applyType;
    private String leaveType;
    private String telephoneNum;
    private String email;
    private String reason;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private Integer status;
}
