package com.boot.microservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//http://127.0.0.1:9091/profile
public class ConfigClientApplication {

		public static void main(String[] args) {
			SpringApplication.run(ConfigClientApplication.class, args);
		}

	}