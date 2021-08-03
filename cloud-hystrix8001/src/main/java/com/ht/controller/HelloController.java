package com.ht.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.ht.model.ResultBean;
import com.ht.service.HelloService;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/6 8:16
 * @description:
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private HelloService helloService;

    @RequestMapping("/hystrix/ok")
    public ResultBean get(){
        return helloService.get();
    }

    @RequestMapping("hystrix/error")
    public ResultBean get1() throws InterruptedException {
        return helloService.get1();
    }

    @RequestMapping("hystrix/error/{id}")
    public ResultBean errorId(@PathVariable("id") Integer id){
        return helloService.error(id);
    }



}
