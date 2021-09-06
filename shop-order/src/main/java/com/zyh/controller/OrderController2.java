package com.zyh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zyh.service.OrderService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController2 {
    @RequestMapping("/order/message1")
    public String message1(){
        return "message1";
    }
    @RequestMapping("/order/message2")
    public String message2(){
        return "message2";
    }
    //测试热点规则
    @RequestMapping("/order/message3")
    @SentinelResource("message3")   //这里必须使用这个注解标注，否则不生效
    public String message3(String name,Integer age){
        return name+age;
    }

    @Autowired
    private OrderService2 orderService2;

    @RequestMapping("/order/message/fallbackTest")
    public String messageFallback(){
        String result = orderService2.message();
        return result;
    }
}
