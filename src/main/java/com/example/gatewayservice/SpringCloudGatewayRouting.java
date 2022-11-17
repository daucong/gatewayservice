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
//                .route(r->r.path("/users/**").uri("http://localhost:8081")) //static routing
//                .route(r->r.path("/categories/**").uri("http://localhost:8081")) //static routing
//                .route(r->r.path("/products/**").uri("http://localhost:8081")) //static routing

                .route(r -> r
                        .path("/api/categories/**")
                        .uri("lb://BE-PRODUCT")
                ) //dynamic routing
                .route(r -> r
                        .path("/api/users/**")
                        .uri("lb://BE-USER")
                ) //dynamic routing
                .route(r -> r
                        .path("/api/products/**")
                        .uri("lb://BE-PRODUCT")
                ) //dynamic routing
                .route(r -> r
                        .path("/categories/**")
                        .uri("lb://FONTEND")
                )
                .route(r -> r
                        .path("/users/**")
                        .uri("lb://FONTEND")
                )
                .route(r -> r
                        .path("/products/**")
                        .uri("lb://FONTEND")
                )
                .build();
    }
}
