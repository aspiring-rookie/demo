package com.zyh.service.impl;

import com.zyh.dao.UserDao;
import com.zyh.entities.User;
import com.zyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }
}
