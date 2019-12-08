package com.ecom.userapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.userapi.entity.User;
import com.ecom.userapi.service.UserService;
import com.ecom.userapi.utils.UserUtils;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<>("welcome user-api", HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@RequestParam String id) {
		return new ResponseEntity<>(userService.getUserById(UserUtils.stringToLong(id)), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Boolean> createUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<Boolean> updateUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> updateUser(@RequestParam String id) {
		return new ResponseEntity<>(userService.delete(UserUtils.stringToLong(id)), HttpStatus.OK);
	}

}
