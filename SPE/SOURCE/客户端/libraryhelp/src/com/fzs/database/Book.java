package com.fzs.database;


public class Book {
	private Integer id;
	private String name;
	private String author;
	private String press;
	private String type;
	private Integer state;
	public Book(Integer id, String name, String author, String press,
			String type, Integer state) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.press = press;
		this.type = type;
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

}
