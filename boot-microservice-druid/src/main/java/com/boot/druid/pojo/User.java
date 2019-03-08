package com.boot.druid.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private List<Role> roles; // 从数据库查询出的Role

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return this.username;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}