package com.boot.vue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.boot.vue.pojo.Status;
import com.boot.vue.service.VueService;

@RestController
public class VueController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private VueService vueService;
	
	@GetMapping("/api/v1/topics")
	Status topics() {
		return vueService.topics();
	}
	
	@GetMapping("/api/v1/topic/{id}")
	Status topic() {
		return vueService.topic();
	}
	
	
	
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }
    
}
