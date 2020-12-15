package com.stuspcloud.controller;


import com.stuspcloud.feginclient.FeginClientDemo;
import com.stuspcloud.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Autowired
    private FeginClientDemo feginClientDemo;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return feginClientDemo.queryById(id);
    }
}
