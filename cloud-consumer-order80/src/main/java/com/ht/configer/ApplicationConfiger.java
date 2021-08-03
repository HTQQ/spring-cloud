package com.ht.configer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/23 18:18
 * @description:
 */
@Configuration
public class ApplicationConfiger {

    @Bean
    @LoadBalanced
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }
}
