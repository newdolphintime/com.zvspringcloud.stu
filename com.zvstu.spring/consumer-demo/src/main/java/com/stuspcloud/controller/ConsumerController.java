package com.stuspcloud.controller;

import com.stuspcloud.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public User queryBYId(@PathVariable long id){

        String url = "http://localhost:9091/user/"+id;
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }
}
