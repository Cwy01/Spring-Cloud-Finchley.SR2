package com.boot.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "boot-microservice-item",fallback = OrderFeignFallbackMethod.class)
public interface OrderFeignClient {
	
	@GetMapping(value = "item")
	String order();
	
	@GetMapping(value = "item2")
    String order2();
	
	@GetMapping(value = "info")
    String info();
}