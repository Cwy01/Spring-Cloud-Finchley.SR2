package com.boot.vue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.vue.pojo.Article;
import com.boot.vue.pojo.Author;
import com.boot.vue.pojo.Status;

@Service
public class VueServiceImpl implements VueService{
	
	static final List<Article> articles = new ArrayList<>();
	Boolean success = true;

	static Article first = new Article("第一章 查看Vue语法介绍","2019-01-14T11:55:26.501Z", new Author("also"),"<div class=\"markdown-text\"><p>第一章 查看Vue语法介绍</p></div>", "0001");
	static Article second = new Article("第二章 查看Vue_Router使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0002");
	
	static {
		articles.add(first);
		articles.add(second);
	}

	@Override
	public Status topics() {
		return new Status(success,articles);
	}

	@Override
	public Status topic() {
		return new Status(success,first);
	}
	
	
}