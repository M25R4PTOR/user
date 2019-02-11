package com.fpdual.user.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private final String firstName;
	private final String lastName;
	private final String nickName;
	private final String password;
	private final String email;
	private final String country;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			final User param = (User) obj;
			final EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder.append(this.nickName, param.getNickName());
			return equalsBuilder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(this.nickName);
		return hashCodeBuilder.toHashCode();
	}

}
