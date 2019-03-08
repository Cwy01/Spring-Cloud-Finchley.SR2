package com.boot.druid.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.druid.pojo.User;

@Mapper
public interface UserDao extends BaseDao<User> {

    List<User> findUserList(User user);

    User getByUsername(String username);

}