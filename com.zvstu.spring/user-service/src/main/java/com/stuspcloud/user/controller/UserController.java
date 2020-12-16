package com.stuspcloud.user.controller;

import com.stuspcloud.user.pojo.User;
import com.stuspcloud.user.service.Uservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope//BUS刷新配置
public class UserController {

    @Autowired
    private Uservice uservice;
    @Value("${test.name}")
    private String name;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable long id){
        System.out.println("字段为name="+name);
        return uservice.getUserById(id);
    }
}
