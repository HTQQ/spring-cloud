package com.ht.controller;

import com.ht.model.ResultBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/28 21:56
 * @description:
 */
@RestController
public class HelloController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("zookeeper/zk")
    public ResultBean getInstance() {
        System.out.println("aaaaaaaaaa");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        System.out.println(instances);
        return new ResultBean(200,serverPort,instances);
    }


}
