package com.fpdual.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpdual.user.model.User;
import com.fpdual.user.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/users")
	public void addUser(@RequestBody UserRequest userRequest) {
		userService.add(UserControllerMapper.toUser(userRequest));
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping("/users/{country}")
	public List<User> getForCountry(@PathVariable String country) {
		return this.userService.find(country);
	}
}
