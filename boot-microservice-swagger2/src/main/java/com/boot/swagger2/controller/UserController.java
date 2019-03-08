package com.boot.swagger2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/user")
@RestController
public class UserController {

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        //userService.deleteUser(id);
        return "success";
    }
    
    @ApiOperation(value="创建用户", notes="创建用户")
    @GetMapping("/get")
    public String postUser() {
      return   "success";

    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }



}