package com.ittx.mybatis.dao;

import com.ittx.mybatis.model.User;

public interface UserDao {

	public User selectUserByID(int id);
	public void insertUser(User user);
	public void deleteUserById(int id);
	public void updateUser(User user);
}
