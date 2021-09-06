package com.zyh.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zyh.handle.OrderService2ImplBlockHandlerClass;
import com.zyh.service.OrderService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService2Impl implements OrderService2 {
    int i = 0;
    @Override
    @SentinelResource(value = "message",
                    blockHandlerClass = OrderService2ImplBlockHandlerClass.class,
                    blockHandler = "blockHandler",
                    fallback = "fallback")
    public String message() {
        if (i%3 == 0){
            throw new RuntimeException();
        }
        return "展示熔断兜底方法项目的主message";
    }

    //Throwable时进入的方法
    public String fallback(Throwable throwable){
        log.error(String.valueOf(throwable));
        return "接口发生了异常……";
    }
}
