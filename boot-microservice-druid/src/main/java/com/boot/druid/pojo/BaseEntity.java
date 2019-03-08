package com.boot.druid.pojo;

import java.io.Serializable;
import java.util.UUID;

import com.boot.druid.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseEntity implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    @JsonIgnore
    public boolean isNewRecord() {
        return StringUtil.isBlank(this.id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void preInsert() {
        setId(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}