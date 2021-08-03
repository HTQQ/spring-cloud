package com.ht.controller;

import com.ht.model.ResultBean;
import com.ht.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.Name;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/6 9:21
 * @description:
 */
@RestController
@DefaultProperties(defaultFallback="defaultFallback")
public class HelloController {

    @Resource
    private HelloService helloService;

    @HystrixCommand
    @RequestMapping("hystrix/ok")
    public ResultBean get(){
        int i = 10/0;
        return helloService.get();
    }

    @RequestMapping("hystrix/error")
    public ResultBean error(){
        return helloService.get1();
    }


    public ResultBean defaultFallback(){
        return new ResultBean(300,"controller嗲用失败");
    }
}
