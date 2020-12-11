package com.stuspcloud.user.controller;

import com.stuspcloud.user.pojo.User;
import com.stuspcloud.user.service.Uservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Uservice uservice;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable long id){
        return uservice.getUserById(id);
    }
}
