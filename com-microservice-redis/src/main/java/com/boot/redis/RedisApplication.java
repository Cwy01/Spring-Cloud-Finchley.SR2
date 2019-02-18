package com.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {
	//http://localhost:9221/redis/get
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}
}