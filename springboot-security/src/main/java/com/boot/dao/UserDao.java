package com.boot.dao;


import com.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>{

	User findByUsername(String username);
}