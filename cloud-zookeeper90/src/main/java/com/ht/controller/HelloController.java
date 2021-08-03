package com.ht.controller;

import com.ht.model.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/28 22:10
 * @description:
 */
@RestController
public class HelloController {


    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://cloud-payment-service";

    @GetMapping("zookeeper/zk")
    public ResultBean get(){
        return restTemplate.getForObject(URL+"/zookeeper/zk",ResultBean.class);
    }


}
