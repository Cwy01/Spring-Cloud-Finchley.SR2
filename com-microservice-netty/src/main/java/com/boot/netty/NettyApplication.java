package com.boot.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class NettyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NettyApplication.class, args);
	}
	

}
