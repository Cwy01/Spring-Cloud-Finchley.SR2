package com.boot.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class NewGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewGatewayApplication.class, args);
    }
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    	String httpUri = "http://127.0.0.1:7777";
    	return builder.routes()
        .route(p -> p
            .path("/info")
            .filters(f -> f.addRequestHeader("Hello", "World"))
            .uri(httpUri))
        .route(p -> p
                .host("127.0.0.1:8768/info")//即将被路由的原始地址
                .filters(f -> f
                    .hystrix(config -> config
                        .setName("mycmd")
                        .setFallbackUri("forward:/GatewayFallback")))
                .uri(httpUri))
        .build();
    }
    // curl --dump-header - --header 'Host: 127.0.0.1:8768/info' http://127.0.0.1:7777/info

    @GetMapping("/GatewayFallback")
    public Mono<String> GatewayFallback() {
        return Mono.just("GatewayFallback");
    }
    
    }