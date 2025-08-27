package com.java.user.dao;

import java.util.List;

import com.java.user.model.User;

public interface UserDao {
	void insertUser(User user);
	boolean updateUser(User user);
	User selectUser(int id);
	List<User> selectAllUsers();
	boolean deleteUser(int id);
}
