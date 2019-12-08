package com.ecom.userapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.userapi.dao.UserReposatory;
import com.ecom.userapi.entity.User;
import com.ecom.userapi.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserReposatory userReposatory;

	@Override
	public List<User> getUsers() {
		return userReposatory.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> user=userReposatory.findById(id);
		return user.orElseThrow(()-> new UserNotFoundException("User","ID",id));
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		Optional<User> extUser=userReposatory.findById(user.getId());
		extUser.orElseThrow(()-> new UserNotFoundException("User","ID",user.getId()));
		User newUser=extUser.get();
		newUser.setFName(user.getFName());
		newUser.setMName(user.getMName());
		newUser.setLName(user.getLName());
		
		userReposatory.save(newUser);
		
		return true;
	}

	@Override
	public boolean delete(Long id) {
		userReposatory.deleteById(id);
		return true;
	}
	
	@Override
	@Transactional
	public boolean save(User user) {
		userReposatory.save(user);
		return true;
	}

}
