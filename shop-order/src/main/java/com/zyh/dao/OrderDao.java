package com.zyh.dao;

import com.zyh.entities.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    public void save(Order order);
}
