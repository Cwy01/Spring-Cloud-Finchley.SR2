package com.boot.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "boot-microservice-order",fallback = PayFeignFallbackMethod.class)
public interface PayFeignClient {
	
	@GetMapping(value = "info")
	String order();

}