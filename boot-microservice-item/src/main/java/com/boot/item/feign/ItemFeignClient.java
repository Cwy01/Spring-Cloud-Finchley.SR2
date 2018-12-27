package com.boot.item.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "boot-microservice-pay",fallback = ItemFeignFallbackMethod.class)
public interface ItemFeignClient {
	
	@GetMapping(value = "pay")
	String item();
	
	@GetMapping(value = "pay2")
    String item2();
	
	@GetMapping(value = "info")
    String info();
}