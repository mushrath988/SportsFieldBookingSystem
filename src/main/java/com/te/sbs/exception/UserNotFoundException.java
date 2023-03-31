package com.te.sbs.exception;
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message, String string,Integer id) {
		super(message);
	}

}
