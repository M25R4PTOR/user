package com.fpdual.user.service.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fpdual.user.messaging.MessageTopic;
import com.fpdual.user.messaging.UserMsgProducer;
import com.fpdual.user.model.User;
import com.fpdual.user.repository.impl.UserRepositoryImpl;

public class UserServiceImplTest {

	private static final String COUNTRY = "SPAIN";

	private static final String NICK = "NICKNAME";

	private UserServiceImpl userService;

	private UserServiceImpl userServiceSpy;

	private final UserRepositoryImpl userRepository = mock(UserRepositoryImpl.class);

	private final User user = mock(User.class);

	private final UserMsgProducer userMsgProducer = mock(UserMsgProducer.class);

	@Before
	public void init() {
		this.userService = new UserServiceImpl(this.userRepository, this.userMsgProducer);
		this.userServiceSpy = spy(this.userService);
	}

	@Test
	public void deberiaAnadirNuevoUsuario() {
		this.userService.add(this.user);

		verify(this.userRepository).add(user);
		verify(this.userMsgProducer).sendMessage(MessageTopic.NEW_USER, this.user);
	}

	@Test
	public void deberiaDevolverUsuarioPorCountry() {
		// Declaro/inicializo variables necesarias
		final List<User> users = new ArrayList<>(Arrays.asList(mock(User.class)));

		// Entrenamiento
		when(this.userRepository.find(COUNTRY)).thenReturn(users);

		// partido, ejecuto el test
		final List<User> resultado = this.userService.find(COUNTRY);

		// Verifico resultados
		assertThat(resultado, is(users));
	}

	@Test
	public void shouldModifyUser() {
		// test
		this.userServiceSpy.modify(NICK, this.user);

		// comprobaciones
		verify(this.userRepository).modify(NICK, this.user);
		verify(this.userServiceSpy).checkNickNameChanged(NICK, this.user);
	}
}
