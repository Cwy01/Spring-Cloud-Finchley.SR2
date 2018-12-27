package com.boot.pay.feign;

import org.springframework.stereotype.Component;

@Component
public class PayFeignFallbackMethod2 implements PayFeignClient2{

	@Override
	public String item() {
		return "item PayFeignFallbackMethod2";
	}

}