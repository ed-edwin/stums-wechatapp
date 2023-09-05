package team.sdjzu.appler.stums.service;

import team.sdjzu.appler.stums.model.dto.processInfoDTO;

import java.util.List;

/**
 * 流程管理接口
 */
public interface processService {
    public void saveInfo(processInfoDTO info);
    public void approval(Integer infoId);
    public List<processInfoDTO> preview();
}
