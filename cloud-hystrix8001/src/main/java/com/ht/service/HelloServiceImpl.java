package com.ht.service;

import com.ht.model.ResultBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/8 10:45
 * @description:
 */
@Service
public class HelloServiceImpl implements HelloService{

    @Value("${server.port}")
    private String serverPort;

    @Override
    public ResultBean get(){
        return new ResultBean(200,serverPort,"hello world!");
    }

    @Override
//    @HystrixCommand(fallbackMethod = "get1Handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "300")
//    })
    public ResultBean get1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return new ResultBean(200,serverPort,"hello stop world !");
    }

    public ResultBean get1Handler(){
        return new ResultBean(200,serverPort,"hello stop world fallbackMethod!");
    }

    @Override
    @HystrixCommand(fallbackMethod = "errorHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 快照时间窗即统计时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //错误百分比
//            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "6")
    })
    public ResultBean error(Integer id) {
        if(id < 10){
            throw new RuntimeException();
        }
        return new ResultBean(200,"成功");
    }

    public ResultBean errorHandler(Integer id){
        return new ResultBean(500,"熔断器开始工作");
    }
}
