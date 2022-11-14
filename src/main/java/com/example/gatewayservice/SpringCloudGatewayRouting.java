package com.example.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productID", r->r.path("/api/products/**").uri("http://localhost:1111")) //static routing
                .route("categoryId", r->r.path("/api/categories/**").uri("http://localhost:1111")) //static routing
                .route("userId", r->r.path("/api/users/**").uri("http://localhost:2222")) //static routing
//                .route("orderId", r->r.path("/order/**").uri("lb://service2")) //dynamic routing
                .build();
    }
}
