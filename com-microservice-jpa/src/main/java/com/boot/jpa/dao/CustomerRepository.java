package com.boot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.pojo.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}