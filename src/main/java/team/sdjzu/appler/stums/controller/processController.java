package team.sdjzu.appler.stums.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.sdjzu.appler.stums.model.dto.processInfoDTO;
import team.sdjzu.appler.stums.service.impl.processServiceImpl;

import java.util.List;

/**
 * 流程管理相关接口
 */

@RestController
@RequestMapping("/process/")
public class processController {
    @Autowired
    private processServiceImpl processService;

    /**
     * 流程申请接口
     * @param info 流程信息
     */
    @SaCheckPermission("process.apply")
    @PostMapping("apply")
    public SaResult apply(processInfoDTO info){
        processService.saveInfo(info);
        return SaResult.ok("上传成功");
    }

    /**
     * 流程审批
     */
    @SaCheckPermission("process.approval")
    @PostMapping("approval")
    public SaResult approval(Integer infoId){
        processService.approval(infoId);
        return SaResult.ok("审批成功");
    }

    /**
     * 查询预览
     * @return 流程列表
     */
    @SaCheckPermission("process.approval")
    @GetMapping("approval")
    public List<processInfoDTO> preview(){
        return processService.preview();
    }

}
