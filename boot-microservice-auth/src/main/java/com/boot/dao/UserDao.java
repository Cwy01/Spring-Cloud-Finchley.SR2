package com.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.pojo.User;

@Mapper
public interface UserDao{
	@Select("select * from user where username = #{username}")
	User findByUsername(String username);
}