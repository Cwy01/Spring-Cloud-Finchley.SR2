package com.boot.jpa.service;

import java.util.List;

import com.boot.jpa.pojo.Customer;

public interface CustomerService {
	List<Customer> findAll();
	Customer save(Customer customer);
}
