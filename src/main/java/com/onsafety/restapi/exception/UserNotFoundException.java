package com.onsafety.restapi.exception;

public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
		super("Nao foi encontrado pessoa com o id " +id);
	}

}
