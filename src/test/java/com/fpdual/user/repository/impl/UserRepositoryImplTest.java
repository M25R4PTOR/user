package com.fpdual.user.repository.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.fpdual.user.exception.UserException;
import com.fpdual.user.model.User;
import com.fpdual.user.model.UserConfiguration;

public class UserRepositoryImplTest {

	private static final String NICK_NAME = "nick";

	private static final String ERR_MESSAGE = "Error nickname existente";

	private UserRepositoryImpl userRepository;

	private UserConfiguration userConfiguration = mock(UserConfiguration.class);

	final User user = mock(User.class);

	@Before // Se ejecuta antes de cada test incluido en esta clase
	public void init() {
		userRepository = new UserRepositoryImpl(userConfiguration);
	}

	@Test
	public void deberiaAnadirNuevoUsuario() {

		this.userRepository.add(user);

		assertThat(this.userRepository.getAllUsers().contains(user), is(true));
	}

	@Test(expected = UserException.class)
	public void deberiaLanzarExcepcionUsuarioYaExiste() {

		when(this.user.getNickName()).thenReturn(NICK_NAME);
		when(this.userConfiguration.getMsgErrUserAlreadyExists()).thenReturn(ERR_MESSAGE);

		this.userRepository.add(user);
		this.userRepository.add(user);
	}

	@Test
	public void deberiaModificarUsuario() {

	}
}
