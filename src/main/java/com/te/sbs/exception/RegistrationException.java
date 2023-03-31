package com.te.sbs.exception;
@SuppressWarnings("serial")
public class RegistrationException extends RuntimeException{
		public RegistrationException(String message, Exception ex) {
			super(message,ex);
		}

}
