package com.boot.item.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.item.feign.ItemFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemControllerTest {
	
	private static final Logger LOG = Logger.getLogger(ItemControllerTest.class.getName());

	@Value("${server.port}")
	private String port;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ItemFeignClient itemFeignClient;
	
	@GetMapping("item")
	public String item() {
		LOG.log(Level.INFO, "info is being called item");
		
		return itemFeignClient.item();
		//String serverId = "boot-microservice-pay";
		//return this.restTemplate.getForObject("http://"+serverId+"/pay",String.class);
	}
	
	@HystrixCommand(fallbackMethod = "itemFallbackMethod")
	@GetMapping("item2")
	public String item2() {
		LOG.log(Level.INFO, "info is being called item2");
		
		//return itemFeignClient.item2();
		String serverId = "boot-microservice-pay";
		return this.restTemplate.getForObject("http://"+serverId+"/pay2",String.class);
	}
	
	public String itemFallbackMethod() {
		return "item2 fallbackMethod";
	}
	
	@GetMapping("info")
	public String info() {
		LOG.log(Level.INFO, "info is being called iteminfo, port:"+port);
		return "this is item, port:"+port;
	}
}
