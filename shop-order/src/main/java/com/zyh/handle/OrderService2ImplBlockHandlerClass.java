package com.zyh.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService2ImplBlockHandlerClass {
    //注意这里必须使用static修饰方法
    public static String blockHandler(BlockException e){
        log.error(String.valueOf(e));
        return "接口被限流或者降级了……";
    }
}
