package com.zyh.controller;

import com.zyh.entities.CommonResult;
import com.zyh.entities.User;
import com.zyh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") Integer id){
      log.info("开始用户的查询");
      User result = userService.findById(id);
      return result;
    }

    @RequestMapping("/user/create")
    public CommonResult create(@RequestBody User user){
        log.info("{}进行注册",user.getUsername());
        int result = userService.create(user);

        log.info("插入结果："+result);
        if (result>0){
            return new CommonResult(200,"用户注册成功",result);
        }else {
            return new CommonResult(400,"用户注册失败",null);
        }
    }

    @GetMapping("/user/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id){
        log.info("开始用户的删除");
        int result = userService.delete(id);
        if (result>0){
            return new CommonResult(200,"用户删除成功",result);
        }else {
            return new CommonResult(400,"用户删除失败",null);
        }
    }

    @RequestMapping("/user/update")
    public CommonResult update(@RequestBody User user){
        log.info("开始用户信息的修改");
        int result = userService.update(user);
        if (result>0){
            return new CommonResult(200,"用户信息更新成功",result);
        }else {
            return new CommonResult(400,"用户信息更新失败",null);
        }
    }

}
