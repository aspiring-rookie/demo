package com.zyh.controller;


import com.alibaba.fastjson.JSON;
import com.zyh.entities.Order;
import com.zyh.entities.Product;
import com.zyh.service.OrderService;
import com.zyh.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductService productService;

/*
    @Autowired
    private DiscoveryClient discoveryClient;
*/
    //准备买1件商品
    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        //直接使用微服务名字，从nacos中获取服务地址
        String url = "service-product";
        //通过restTemplate调用商品微服务
        //Product product = restTemplate.getForObject("http://"+url+"/product/"+pid,Product.class);
        //通过feign调用商品微服务
        Product product = productService.findById(pid);
        if (product.getPid() == -1){
            Order order = new Order();
            order.setPname("下单失败");
            return order;
        }
        log.info("商品信息，查询结果："+JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUname("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNum(1);
        orderService.save(order);
        log.info("创建订单成功，订单信息为{}",JSON.toJSONString(order));
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return order;
    }
}

/*//从nacos中获取服务地址
        //自定义规则实现随机挑选服务
        *//*List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        int index = new Random().nextInt(instances.size());
        ServiceInstance serviceInstance = instances.get(index);
        String url = serviceInstance.getHost() + ":" +serviceInstance.getPort();
        log.info(">>从nacos中获取到的微服务地址为："+url);
        //通过restTemplate调用商品微服务
        Product product = restTemplate.getForObject("http://"+url+"/product/"+pid,Product.class);
        log.info(">>商品信息，查询结果："+JSON.toJSONString(product));*//*

        //直接使用微服务名字，从nacos中获取服务地址
        String url = "service-product";
        //通过restTemplate调用商品微服务
        //Product product = restTemplate.getForObject("http://"+url+"/product/"+pid,Product.class);
        //通过feign调用商品微服务
        Product product = productService.findById(pid);
        log.info("商品信息，查询结果："+JSON.toJSONString(product));

        Order order = new Order();
        order.setUid(1);
        order.setUname("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNum(1);
        orderService.save(order);
        return order;*/