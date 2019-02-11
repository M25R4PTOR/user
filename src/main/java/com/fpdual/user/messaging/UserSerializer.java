package com.fpdual.user.messaging;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpdual.user.exception.UserException;
import com.fpdual.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserSerializer implements Serializer<User> {

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] serialize(String arg0, User user) {

		byte[] serializedBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			serializedBytes = objectMapper.writeValueAsString(user).getBytes();
		} catch (Exception e) {
			log.error("err.serialize.user");
			throw new UserException("err.serialize.user", e);
		}
		return serializedBytes;
	}

}
