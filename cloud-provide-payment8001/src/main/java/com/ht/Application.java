package com.ht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/22 16:38
 * @description:
 */
@SpringBootApplication
@MapperScan("com.ht.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
