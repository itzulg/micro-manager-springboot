package com.manager.micro.data.exceptions;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -6734347388818009347L;

}
