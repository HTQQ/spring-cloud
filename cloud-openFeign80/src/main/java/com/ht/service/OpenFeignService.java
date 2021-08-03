package com.ht.service;

import com.ht.model.Payment;
import com.ht.model.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/2 16:01
 * @description:
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {

    @GetMapping("payment/selectOne")
    public ResultBean<Payment> selectOne(@RequestParam("id") Integer id);



}
