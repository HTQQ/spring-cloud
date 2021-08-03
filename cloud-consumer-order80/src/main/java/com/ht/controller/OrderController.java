package com.ht.controller;

import com.ht.model.Payment;
import com.ht.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/23 18:08
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("${spring.application.name}")
//    private String serverName;

    private static final String SERVER_NAME = "http://CLOUD-PAYMENT-SERVICE";

    @RequestMapping("/consumer/get")
    public ResultBean<Payment> get(Integer id){
        log.info("进来了");
        return restTemplate.getForObject(SERVER_NAME+"/payment/selectOne?id="+id,ResultBean.class);
    }
}
