package com.nnuclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:31 2024/8/30
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @RequestMapping("/test")
    public String test(){
        log.info("接收到前端请求，开始处理。。。");
        return "test";
    }
}