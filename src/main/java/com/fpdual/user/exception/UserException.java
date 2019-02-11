package com.fpdual.user.exception;

public class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8992126141030746113L;

	public UserException(String err, Exception cause) {
		super(err, cause);
	}
}
