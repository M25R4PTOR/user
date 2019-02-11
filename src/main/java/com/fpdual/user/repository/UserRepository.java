package com.fpdual.user.repository;

import java.util.List;

import com.fpdual.user.model.User;

public interface UserRepository {

	void add(User user);

	void modify(String nickName, User user);

	void remove(User user);

	List<User> find(String country);

	List<User> getAllUsers();
}
