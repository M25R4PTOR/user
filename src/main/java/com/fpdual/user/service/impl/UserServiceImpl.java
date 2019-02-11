package com.fpdual.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpdual.user.messaging.MessageTopic;
import com.fpdual.user.messaging.UserMsgProducer;
import com.fpdual.user.model.User;
import com.fpdual.user.repository.UserRepository;
import com.fpdual.user.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMsgProducer userMsgProducer;

	@Override
	public void add(User user) {
		this.userRepository.add(user);
		log.debug("Usuario creado " + user.getNickName());

		userMsgProducer.sendMessage(MessageTopic.NEW_USER, user);
	}

	@Override
	public void modify(String nickName, User user) {
		this.userRepository.modify(nickName, user);

		this.checkNickNameChanged(nickName, user);
	}

	protected void checkNickNameChanged(String nickName, User user) {
		if (!nickName.equals(user.getNickName())) {
			userMsgProducer.sendMessage(MessageTopic.NICK_NAME_CHANGED, user);
		}
	}

	@Override
	public void remove(User user) {
		this.userRepository.remove(user);
	}

	@Override
	public List<User> find(String country) {
		return this.userRepository.find(country);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.getAllUsers();
	}

}
