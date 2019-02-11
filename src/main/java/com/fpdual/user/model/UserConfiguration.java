package com.fpdual.user.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties
@Data
public class UserConfiguration {

	private String msgErrUserAlreadyExists;

	private String msgErrUserNotExists;
}
