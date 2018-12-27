package com.boot.order.feign;

import org.springframework.stereotype.Component;

@Component
public class OrderFeignFallbackMethod implements OrderFeignClient{

	@Override
	public String order() {
		return "order OrderFeignFallbackMethod";
	}

	@Override
	public String order2() {
		return "order2 OrderFeignFallbackMethod";
	}

	@Override
	public String info() {
		return "info OrderFeignFallbackMethod";
	}
}