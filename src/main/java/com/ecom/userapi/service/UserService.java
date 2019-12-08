package com.ecom.userapi.service;

import java.util.List;

import com.ecom.userapi.entity.User;

public interface UserService {

	public List<User> getUsers();
	public User getUserById(Long id);
	public boolean updateUser(User user);
	public boolean delete(Long id);
	public boolean save(User user);
	
}
