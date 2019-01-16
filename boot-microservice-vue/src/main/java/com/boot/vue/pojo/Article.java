package com.boot.vue.pojo;

public class Article {

	private String title;
	private String create_at;
	private Author author;	
	private String content;
	private String id;
	
	public Article(String title, String create_at, Author author, String content, String id) {
		super();
		this.title = title;
		this.create_at = create_at;
		this.author = author;
		this.content = content;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}