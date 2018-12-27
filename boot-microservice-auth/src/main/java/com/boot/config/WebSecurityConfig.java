package com.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.boot.service.UserServiceDetail;

@Configuration
@EnableWebSecurity  //开启Web保护功能
@EnableGlobalMethodSecurity(prePostEnabled = true)  //在方法上的保护功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserServiceDetail userServiceDetail;
	
	//HttpSecurity配置了所有的请求都需要安全验证
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
	}
	
	//配置了验证的用户信息源和密码加密的策略，密码验证
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceDetail).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//配置了验证管理的Bean
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
		
	}
}
