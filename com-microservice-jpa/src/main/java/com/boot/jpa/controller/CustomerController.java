package com.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.pojo.Customer;
import com.boot.jpa.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public List<Customer> findAll(){
		System.out.println(customerService.findAll().toString());
		return customerService.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Customer getOne(@PathVariable("id")Long id){
		System.out.println(customerService.save());
		return customerService.save();
	}*/
	
	@GetMapping("/{customername}")
	public Customer save(@PathVariable("customername")String customername){
		System.out.println("保存成功");
		Customer customer = new Customer();
		customer.setCustomername(customername);
		return customerService.save(customer);
	}
}
