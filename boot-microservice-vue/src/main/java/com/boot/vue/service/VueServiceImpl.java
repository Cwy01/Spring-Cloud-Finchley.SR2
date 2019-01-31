package com.boot.vue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.vue.pojo.Article;
import com.boot.vue.pojo.Author;
import com.boot.vue.pojo.Pie;
import com.boot.vue.pojo.Status;
import com.boot.vue.pojo.TableStatus;

@Service
public class VueServiceImpl implements VueService{
	
	static final List<Article> articles = new ArrayList<>();
	static final List<Pie> pies = new ArrayList<>();
	Boolean success = true;

	static Article first = new Article("第一章 查看Vue语法介绍","2019-01-14T11:55:26.501Z", new Author("also"),"<div class=\"markdown-text\"><p>第一章 查看Vue语法介绍</p></div>", "0001");
	static Article second = new Article("第二章 查看Vue_Router使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0002");
	static Article third = new Article("第三章 查看Bootstrap使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0003");
	static Article fourth = new Article("第四章 查看VueCli使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0004");
	static Article fifth = new Article("第五章 查看Echarts使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0005");
	static Article sixth = new Article("第六章 查看axios使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0006");
	static Article fourth2 = new Article("第四章 查看VueCli使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0004");
	static Article fifth2 = new Article("第五章 查看Echarts使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0005");
	static Article sixth2 = new Article("第六章 查看axios使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0006");
	static Article fourth3 = new Article("第四章 查看VueCli使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0004");
	static Article fifth3 = new Article("第五章 查看Echarts使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0005");
	static Article sixth3 = new Article("第六章 查看axios使用","2019-01-14T11:55:26.501Z", new Author("tang"), "<div class=\"markdown-text\"><p>第二章 查看Vue_Router使用</p></div>", "0006");
	static Pie pie1 = new Pie("访问",335);
	static Pie pie2 = new Pie("营销",234);
	static Pie pie3 = new Pie("广告",234);
	static Pie pie4 = new Pie("引擎",135);
	
	static {
		articles.add(first);
		articles.add(second);
		articles.add(third);
		articles.add(fourth);
		articles.add(fifth);
		articles.add(sixth);
		articles.add(fourth2);
		articles.add(fifth2);
		articles.add(sixth2);
		articles.add(fourth3);
		articles.add(fifth3);
		articles.add(sixth3);
		pies.add(pie1);
		pies.add(pie2);
		pies.add(pie3);
		pies.add(pie4);
	}

	@Override
	public Status topics() {
		return new Status(success,articles);
	}

	@Override
	public Status topic() {
		return new Status(success,first);
	}
	
	@Override
	public Status pieDatas() {
		return new Status(success,pies);
	}
	
	@Override
	public TableStatus tableDatas() {
		return new TableStatus(12,articles);
	}
}