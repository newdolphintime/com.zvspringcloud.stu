package com.stuspcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.stuspcloud.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/{id}")
    @HystrixCommand(fallbackMethod ="queryByIdFallBack")//配置降级方法
    public String queryBYId(@PathVariable Long id){

//        String url = "";
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("user-service");
//        ServiceInstance serviceInstance = serviceInstanceList.get(0);
//        url= "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() +"/user/"+id;
        String url = "http://user-service/user/"+id;
        String user = restTemplate.getForObject(url,String.class);
        return user;
    }

    public String queryByIdFallBack(Long id){
        return "查询信息失败ID:"+id;
    }
}
