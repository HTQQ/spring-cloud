package com.myIRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/1 17:08
 * @description:
 */
@Configuration
public class MyIRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
