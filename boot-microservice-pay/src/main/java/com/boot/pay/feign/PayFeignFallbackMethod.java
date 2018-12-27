package com.boot.pay.feign;

import org.springframework.stereotype.Component;

@Component
public class PayFeignFallbackMethod implements PayFeignClient{

	@Override
	public String order() {
		return "info PayFeignFallbackMethod";
	}

}