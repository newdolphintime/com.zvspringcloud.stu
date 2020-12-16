package com.stuspcloud.user.service;

import com.stuspcloud.user.mapper.UserMapper;
import com.stuspcloud.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Uservice {
    @Autowired
    private UserMapper userMapper;


    public User getUserById(long id){
        //System.out.println("配置文件中的test.name = " + name);
        return userMapper.selectByPrimaryKey(id);
    }
}
