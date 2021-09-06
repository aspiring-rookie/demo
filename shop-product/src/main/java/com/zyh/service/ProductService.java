package com.zyh.service;


import com.zyh.entities.Product;


public interface ProductService {
    public int create(Product product);
    public Product findByPid(Integer pid);
}
