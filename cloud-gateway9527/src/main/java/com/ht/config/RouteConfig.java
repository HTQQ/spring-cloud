package com.ht.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/14 8:45
 * @description:
 */
@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("route_id",
                r -> r.path("/**")
                        .uri("lb://cloud-payment-service").filters(new MyFilter()));
        return routes.build();
    }
}
