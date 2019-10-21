package com.dx.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // 从application.yml中读取配置
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/getPortInfo")
    public String getPortInfo() {
        return "The port is " + serverPort;
    }
}
