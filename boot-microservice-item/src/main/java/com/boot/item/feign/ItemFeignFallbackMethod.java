package com.boot.item.feign;

import org.springframework.stereotype.Component;

@Component
public class ItemFeignFallbackMethod implements ItemFeignClient{

	@Override
	public String item() {
		return "item ItemFeignFallbackMethod";
	}

	@Override
	public String item2() {
		return "item2 ItemFeignFallbackMethod";
	}

	@Override
	public String info() {
		return "info ItemFeignFallbackMethod";
	}

}
