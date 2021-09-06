package com.zyh.service;

import com.zyh.entities.Product;
import com.zyh.service.impl.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product",fallback = ProductServiceFallBack.class) //声明调用的提供者的name
public interface ProductService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping 就是一个完整的请求路径 http://serviceproduct/product/{pid}
    @GetMapping(value = "/product/{pid}")
    //指定请求的URI部分
    Product findById(@PathVariable Integer pid);
}
