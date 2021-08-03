package com.ht.service;

import com.ht.model.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/6 9:21
 * @description:
 */

@FeignClient(value = "HYSTRIX-SERVER",fallback = HystrixService.class)
public interface HelloService {
    @RequestMapping("/hystrix/ok")
    public ResultBean get();

    @RequestMapping("hystrix/error")
    public ResultBean get1();
}
