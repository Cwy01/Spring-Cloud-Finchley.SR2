package com.boot.pay.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.pay.dao.RedisDao;
import com.boot.pay.feign.PayFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("index")
public class PayController {
	
	private static final Logger LOG = Logger.getLogger(PayController.class.getName());

	@Value("${server.port}")
	private String port;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PayFeignClient payFeignClient;
	
	@Autowired
	private PayFeignClient payFeignClient2;
	
	@Autowired
	RedisDao redisDao;
	
	@GetMapping("pay")
	public String order() {
		LOG.log(Level.INFO, "info is being called pay");
		
		return this.payFeignClient.order();
		//String serverId = "boot-microservice-order";
		//return this.restTemplate.getForObject("http://"+serverId+"/info",String.class);
	}
	
	@HystrixCommand(fallbackMethod = "payFallbackMethod")
	@GetMapping("pay2")
	public String pay2() {
		LOG.log(Level.INFO, "info is being called pay2");
		
		//return this.payFeignClient2.order();
		String serverId = "boot-microservice-item";
		return this.restTemplate.getForObject("http://"+serverId+"/info",String.class);
	}
	public String payFallbackMethod() {
		return "pay2 fallbackMethod";
	}
	
	@GetMapping("info")
	public String info() {
		LOG.log(Level.INFO, "info is being called payinfo, port:"+port);
		redisDao.setKey("name","this is payRedis");
		redisDao.setKey("age","redis");
		return "this is pay, port:"+port+"\n"+redisDao.getValue("name")+":"+redisDao.getValue("age");
	}
}
