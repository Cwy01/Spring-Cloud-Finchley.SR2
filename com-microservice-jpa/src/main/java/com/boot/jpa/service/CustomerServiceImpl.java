package com.boot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jpa.dao.CustomerRepository;
import com.boot.jpa.pojo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
}
