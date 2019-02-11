package com.fpdual.user.messaging;

import lombok.Getter;

@Getter
public enum MessageTopic {
	NEW_USER("new_user"), NICK_NAME_CHANGED("nick_name_changed");

	private String codigo;

	MessageTopic(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.toString();
	}
}
