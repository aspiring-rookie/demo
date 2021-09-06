package com.zyh.service;

import com.zyh.entities.User;

import java.util.List;

public interface UserService {
    public int create(User user);
    public User findById(Integer id);
    public int update(User user);
    public int delete(Integer id);
}
