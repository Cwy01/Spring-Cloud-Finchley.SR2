package com.boot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.boot.dao.UserDao;
import com.boot.pojo.Role;
import com.boot.pojo.User;

public class UserServiceDetail implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	static {
		User user = new User();
		Role authorities = new Role();
		authorities.setId(1L);
		authorities.setName("ADMIN");
		ArrayList<Role> list = new ArrayList<Role>();
		user.setId(1L);
		user.setUsername("fzp");
		user.setPassword("123456");
		user.setAuthorities(list);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userDao.findByUsername(username);
	}

}
