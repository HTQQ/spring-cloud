package com.ht;

import com.myIRule.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/23 18:04
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyIRule.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
