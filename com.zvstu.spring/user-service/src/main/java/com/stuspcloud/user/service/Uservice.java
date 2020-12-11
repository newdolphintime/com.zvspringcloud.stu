package com.stuspcloud.user.service;

import com.stuspcloud.user.mapper.UserMapper;
import com.stuspcloud.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Uservice {
    @Autowired
    private UserMapper userMapper;


    public User getUserById(long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
