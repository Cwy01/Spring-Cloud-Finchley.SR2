package com.boot.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "boot-microservice-item",fallback = PayFeignFallbackMethod2.class)
public interface PayFeignClient2 {

	@GetMapping(value = "info")
    String item();
}