package com.boot.swagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerApplication {
	//http://localhost:9113/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
}