package com.ht.controller;

import com.ht.model.Payment;
import com.ht.model.ResultBean;
import com.ht.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2021-06-23 09:32:27
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ResultBean<Payment> selectOne(Integer id) {
        Payment payment = this.paymentService.queryById(id);
        return new ResultBean<>(200, serverPort, payment);
    }

    @GetMapping("discovery")
    public ResultBean getDiscovery() {

        List<String> services = discoveryClient.getServices();
        for (String el : services) {
            log.info(el);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        return new ResultBean(200, serverPort, instances);
    }

}
