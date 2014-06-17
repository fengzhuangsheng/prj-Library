package com.fzs.dao;

import com.fzs.entity.User;

public interface UserDao {
	public User login(String username,String password);
	public boolean register(User user);
	public boolean check(String username);
}
