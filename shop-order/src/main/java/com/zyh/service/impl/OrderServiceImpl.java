package com.zyh.service.impl;

import com.zyh.dao.OrderDao;
import com.zyh.entities.Order;
import com.zyh.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
         orderDao.save(order);
    }
}
