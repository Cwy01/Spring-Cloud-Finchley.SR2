package com.boot.vue.pojo;

public class Author {
	private String loginname;
	
	public Author(String loginname) {
		super();
		this.loginname = loginname;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
}