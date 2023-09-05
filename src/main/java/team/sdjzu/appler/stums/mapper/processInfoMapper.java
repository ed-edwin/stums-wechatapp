package team.sdjzu.appler.stums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.sdjzu.appler.stums.model.dto.processInfoDTO;

import java.util.List;

/**
 * 流程Mapper
 */
@Mapper
public interface processInfoMapper extends BaseMapper<processInfoDTO> {
    /**
     * 流程列表查询
     * @return 流程列表
     */
    @Select("SELECT DISTINCT " +
            "process_info.* " +
            "FROM " +
            "process_info")
    public List<processInfoDTO> queryInfoList();

    /**
     * 通过infoId查询流程状态
     * @param infoId 流程id
     * @return status
     */
    @Select("SELECT " +
            "process_info.`status` " +
            "FROM " +
            "process_info " +
            "WHERE " +
            "process_info.user_id = #{infoId}")
    public Integer queryStatus(@Param("infoId") Integer infoId);

    /**
     * 批准
     * @param infoId 流程id
     */
    @Update("UPDATE " +
            "stums.process_info " +
            "SET " +
            "status = 1 " +
            "WHERE info_id = #{infoId}")
    public void updateStatus(@Param("infoId") Integer infoId);
}
