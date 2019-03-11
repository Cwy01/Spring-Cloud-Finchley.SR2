package com.boot.mongodb.dao;

import com.boot.mongodb.pojo.User;

public interface IUserDao {
    
    void saveUser(User user);
    User findUserByName(String name);
    void updateUser(User user);
    void deleteUserById(Integer id);
}