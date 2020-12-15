package com.stuspcloud.feginclient;

import com.stuspcloud.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//首先这是一个接口，Feign会通过动态代理，帮我们生成实现类。这点跟mybatis的mapper很像
//@FeignClient ，声明这是一个Feign客户端，同时通过 value 属性指定服务名称
//接口中的定义方法，完全采用SpringMVC的注解，Feign会根据注解帮我们生成URL，并访问获取结果
//@GetMapping中的/user，请不要忘记;因为Feign需要拼接可访问的地址
@FeignClient(value = "user-service",fallback = FeignClientFallback.class,
        configuration = FeginConfig.class)
public interface FeginClientDemo {
    @GetMapping("/user/{id}")
    User queryById(@PathVariable Long id);
}
