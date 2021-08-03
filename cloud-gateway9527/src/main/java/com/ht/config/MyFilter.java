package com.ht.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/19 10:45
 * @description:
 */
public class MyFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("自定义网关过滤器执行");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
