package com.zyh.dao;

import com.zyh.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public int create(User user);
    public User findById(Integer id);
    public int update(User user);
    public int delete(Integer uid);
}
