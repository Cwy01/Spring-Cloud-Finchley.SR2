package com.boot.druid.pojo;

import java.io.Serializable;

public class Role extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public Role() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}