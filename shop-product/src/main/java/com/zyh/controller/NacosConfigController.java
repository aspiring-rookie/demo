//package com.zyh.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RefreshScope
//public class NacosConfigController {
//
//    @Value("${config.env}")
//    public String env;
//
//    @GetMapping("/nacos-config")
//    public String nacosConfig(){
//        return env;
//    }
//}
