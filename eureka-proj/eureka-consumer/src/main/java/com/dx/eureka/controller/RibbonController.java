package com.dx.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getProviderInfo")
    public String getProviderInfo() {
        String result = this.restTemplate.getForObject("http://EUREKA-PROVIDER-01/getPortInfo", String.class);
        return result;
    }
}