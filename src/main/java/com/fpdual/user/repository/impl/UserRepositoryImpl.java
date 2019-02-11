package com.fpdual.user.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fpdual.user.exception.UserException;
import com.fpdual.user.model.User;
import com.fpdual.user.model.UserConfiguration;
import com.fpdual.user.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

	private final UserConfiguration userConfiguration;

	// Lista concurrente
	private final List<User> users = new ArrayList<>();

	@Override
	public void add(User user) {
		// if(users.stream().filter(u ->
		// u.getNickName().equals(user.getNickName())).findAny().orElse(null) != null) {
		// throw UserException("El usuario ya existe");
		// }
		if (users.stream().anyMatch(u -> u.equals(user))) {
			log.error(userConfiguration.getMsgErrUserAlreadyExists(), user);
			throw new UserException(userConfiguration.getMsgErrUserAlreadyExists(), null);
		}
		users.add(user);
	}

	@Override
	public void modify(String nickName, User user) {
		final User oldUser = this.users.stream().filter(u -> u.getNickName().equals(nickName)).findFirst().orElse(null);

		if (Objects.isNull(oldUser)) {
			log.error(userConfiguration.getMsgErrUserNotExists(), user);
			throw new UserException(userConfiguration.getMsgErrUserNotExists(), null);
		}
		this.users.set(users.indexOf(oldUser), user);
	}

	@Override
	public void remove(User user) {
		final boolean eliminado = this.users.remove(user);

		if (!eliminado) {
			log.error(userConfiguration.getMsgErrUserNotExists(), user);
			throw new UserException(userConfiguration.getMsgErrUserNotExists(), null);
		}
	}

	@Override
	public List<User> find(String country) {
		return this.users.stream().filter(u -> u.getCountry().equals(country)).collect(Collectors.toList());
	}

	@Override
	public List<User> getAllUsers() {
		// Devolvemos una copia de la lista para que no puedan modificarla
		return this.users.stream().collect(Collectors.toList());
	}

}
