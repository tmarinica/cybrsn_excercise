package com.pokeapi.exceptions;

public class InvalidFieldNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidFieldNameException(String message) {
		super(message);
	}

}
