package com.zyh.service.impl;

import com.zyh.entities.Product;
import com.zyh.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findById(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        return product;
    }
}
