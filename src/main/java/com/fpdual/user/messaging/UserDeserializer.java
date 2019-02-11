package com.fpdual.user.messaging;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpdual.user.exception.UserException;
import com.fpdual.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDeserializer implements Deserializer<User> {

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public User deserialize(String arg0, byte[] userBytes) {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = null;
		try {
			user = objectMapper.readValue(userBytes, User.class);
		} catch (Exception e) {
			log.error("err.deserialize.user");
			throw new UserException("err.deserialize.user", e);
		}
		return user;
	}

}
