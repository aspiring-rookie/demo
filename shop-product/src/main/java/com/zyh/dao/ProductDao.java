package com.zyh.dao;

import com.zyh.entities.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao {
    public int create(Product product);

    public Product getProductById(@Param("pid") int pid);
}
