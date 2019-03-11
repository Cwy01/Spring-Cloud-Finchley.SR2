package com.boot.mongodb.controller;
 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.mongodb.pojo.User;
import com.boot.mongodb.service.UserService;
 
@RestController
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @GetMapping(value="/save")
    public void saveUser() throws Exception {
        User user=new User();
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setAge(33);
        user.setName("ceshi");
        userService.saveUser(user);
    }
 
    @GetMapping(value="/find")
    public User findUserByName(){
        User user= userService.findUserByName("ceshi");
        System.out.println("user is "+user);
        return user;
    }
 
    @GetMapping(value="/update")
    public void updateUser(){
        User user=new User();
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setAge(44);
        user.setName("ceshi2");
        userService.updateUser(user);
    }
 
    @GetMapping(value="/delete")
    public void deleteUserById(){
    	userService.deleteUserById(11);
    }
}