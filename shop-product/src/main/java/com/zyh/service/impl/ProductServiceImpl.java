package com.zyh.service.impl;

import com.zyh.dao.ProductDao;
import com.zyh.entities.Product;
import com.zyh.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public int create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product findByPid(Integer pid) {
        return productDao.getProductById(pid);
    }
}
