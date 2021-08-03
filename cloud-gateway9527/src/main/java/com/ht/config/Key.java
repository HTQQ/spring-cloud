package com.ht.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/20 8:09
 * @description:
 */
@Configuration
public class Key {

    @Bean
    public KeyResolver keyResolver() {
//        KeyResolver resolver = new KeyResolver() {
//            @Override
//            public Mono<String> resolve(ServerWebExchange exchange) {
//                return null;
//            }
//        }
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
