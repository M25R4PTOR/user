package com.fpdual.user.controller;

import com.fpdual.user.model.User;

public class UserControllerMapper {

	private UserControllerMapper() {
	}

	public static User toUser(UserRequest userRequest) {
		return User.builder().firstName(userRequest.getFirstName()).lastName(userRequest.getLastName())
				.nickName(userRequest.getNickName()).password(userRequest.getPassword()).email(userRequest.getEmail())
				.country(userRequest.getCountry()).build();
	}
}
