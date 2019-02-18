package com.boot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.redis.dao.RedisDao;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
	RedisDao redisDao;
	
	@GetMapping("/get")
	public String getRedis(){
		redisDao.setKey("name","tom");
		redisDao.setKey("age","21");
		return "name:"+redisDao.getValue("name")+",age:"+redisDao.getValue("age");
	}
}
