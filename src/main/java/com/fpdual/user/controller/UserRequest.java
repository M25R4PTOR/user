package com.fpdual.user.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String nickName;

	@NonNull
	private String password;

	@NonNull
	private String email;

	@NonNull
	private String country;
}
