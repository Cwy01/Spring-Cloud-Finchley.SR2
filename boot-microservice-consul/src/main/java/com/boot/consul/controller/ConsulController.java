package com.boot.consul.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {
	
	private static final Logger LOG = Logger.getLogger(ConsulController.class.getName());

	@Value("${server.port}")
	private String port;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("consul")
	public String consul() {
		LOG.log(Level.INFO, "info is being called consul");
	
		String serverId = "boot-microservice-consul";
		return serverId;
	}
	
	@GetMapping("info")
	public String info() {
		LOG.log(Level.INFO, "info is being called consulinfo, port:"+port);
		
		return "this is consul, port:"+port;
	}
	
}