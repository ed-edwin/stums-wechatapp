package team.sdjzu.appler.stums.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sdjzu.appler.stums.mapper.processInfoMapper;
import team.sdjzu.appler.stums.model.dto.processInfoDTO;
import team.sdjzu.appler.stums.service.processService;

import java.util.List;

/**
 * 流程管理实现类
 */

@Service
public class processServiceImpl implements processService {
    @Autowired
    private processInfoMapper processInfoMapper;

    /**
     * 新建流程
     * @param info 流程信息
     */
    @Override
    public void saveInfo(processInfoDTO info) {
        Integer id = StpUtil.getLoginIdAsInt();
        info.setUserId(id);
        processInfoMapper.insert(info);
    }

    /**
     * 批准流程
     * @param infoId 流程id
     */
    @Override
    public void approval(Integer infoId) {
        Integer status = processInfoMapper.queryStatus(infoId);
        if (status == 0){
            processInfoMapper.updateStatus(1);
        }
    }

    /**
     * 流程预览
     * @return 流程列表
     */
    @Override
    public List<processInfoDTO> preview() {
        return processInfoMapper.queryInfoList();
    }

}
