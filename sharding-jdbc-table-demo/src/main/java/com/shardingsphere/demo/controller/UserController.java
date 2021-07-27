package com.shardingsphere.demo.controller;

import com.shardingsphere.demo.entity.TUser;
import com.shardingsphere.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public void insert() {
        TUser user = new TUser();
        user.setName("用户名称");
        user.setCreateTime(new Date());
        userService.insert(user);
    }
}
