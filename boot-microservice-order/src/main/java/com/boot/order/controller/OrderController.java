package com.boot.order.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.order.feign.OrderFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderController {
	
	private static final Logger LOG = Logger.getLogger(OrderController.class.getName());
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderFeignClient orderFeignClient;
	
	@GetMapping("/order")
	public String order() {
		LOG.log(Level.INFO, "info is being called order");
		
		return this.orderFeignClient.order();
		//String serverId = "boot-microservice-item";
		//return this.restTemplate.getForObject("http://"+serverId+"/item",String.class);
	}
	
	@HystrixCommand(fallbackMethod = "orderFallbackMethod")
	@GetMapping("order2")
	public String order2() {
		LOG.log(Level.INFO, "info is being called order2");
		
		//return this.orderFeignClient.order2();
		String serverId = "boot-microservice-item";
		return this.restTemplate.getForObject("http://"+serverId+"/item2",String.class);
		
	}
	public String orderFallbackMethod() {
		return "order2 fallbackMethod";
	}
	
	@GetMapping("info")
	public String info() {
		LOG.log(Level.INFO, "info is being called orderinfo, port:"+port);
		
		return "this is order, port:"+port;
	}
}