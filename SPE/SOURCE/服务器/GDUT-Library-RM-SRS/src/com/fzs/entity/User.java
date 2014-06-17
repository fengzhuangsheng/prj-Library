package com.fzs.entity;

import java.io.Serializable;

/**
 * 
 * @author fzs ���ڷ�װuserinfo���ʵ����
 */
public class User implements Serializable {
	private String username;
	private String password;
	private int age;
	private String sex;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, int age, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
