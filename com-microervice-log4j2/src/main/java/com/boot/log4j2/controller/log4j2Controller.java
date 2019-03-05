package com.boot.log4j2.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.log4j2.util.LogUtils;

@RestController
public class log4j2Controller {
	
	@GetMapping("/info")
	String info() {
		Logger log = LogUtils.getExceptionLogger();
    	Logger log1 = LogUtils.getBussinessLogger();
    	Logger log2 = LogUtils.getDBLogger();
    	
    	log.debug("getExceptionLogger==debug=日志测试");
    	log.error("getExceptionLogger==error=日志测试");
    	log1.error("getExceptionLogger==error=日志测试");
    	log1.info("getBussinessLogger==info=日志测试");
    	log2.info("getDBLogger==info=日志测试");
		return "info";
	}
	
}