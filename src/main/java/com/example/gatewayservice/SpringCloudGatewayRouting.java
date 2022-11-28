package com.example.gatewayservice;

import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
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
//                .filters(f -> f.filter(filterFactory.apply())), TokenRelayGatewayFilterFactory filterFactory
                .route(r -> r
                        .path("/api/categories/**")
                        .uri("lb://BE-PRODUCT")
                ) //dynamic routing
                .route(r -> r.path("/api/users/**")
                        .uri("lb://BE-USER")
                ) //dynamic routing
                .route(r -> r
                        .path("/api/products/**")
                        .uri("lb://BE-PRODUCT")
                ) //dynamic routing
                //load js
                .route(r -> r
                        .path("/js/**")
                        .uri("lb://FONTEND")
                )
                .route(r -> r
                        .path("/css/**")
                        .uri("lb://FONTEND")
                )
                .route(r -> r
                        .path("/admin/**")
                        .uri("lb://FONTEND")
                )
                .build();
    }
}
