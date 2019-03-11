package com.boot.mongodb.service;

import com.boot.mongodb.pojo.User;

public interface IUserService{
    
    public void saveUser(User user);
    public User findUserByName(String name);
    public void updateUser(User user);
    public void deleteUserById(Integer id);
}