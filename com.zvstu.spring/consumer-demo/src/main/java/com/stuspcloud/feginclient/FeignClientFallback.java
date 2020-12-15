package com.stuspcloud.feginclient;

import com.stuspcloud.user.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements FeginClientDemo{
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUserName("用户异常");
        return user;
    }
}
