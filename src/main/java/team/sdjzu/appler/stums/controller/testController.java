package team.sdjzu.appler.stums.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/test")
public class testController {
    @GetMapping("/1")
    public void test1(){
        log.info(StpUtil.getLoginId().toString());
    }
    @GetMapping("/2")
    public ResponseEntity<String> test2(){
        return ResponseEntity.ok().
                body("11212");
    }
}
