package com.boot.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableSwagger2Doc
public class SwaggerStarterApplication {
	//http://localhost:9117/swagger-ui.html
    public static void main(String[] args) {
        SpringApplication.run(SwaggerStarterApplication.class, args);
    }
}