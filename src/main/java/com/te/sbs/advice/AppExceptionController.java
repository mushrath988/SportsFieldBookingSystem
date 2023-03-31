package com.te.sbs.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.sbs.exception.PaymentNotSuccessful;
import com.te.sbs.exception.RegistrationException;
import com.te.sbs.exception.UserNotFoundException;
import com.te.sbs.response.Response;

@RestControllerAdvice
public class AppExceptionController {
	@Autowired
	private Response response;

	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<Response> registrationException(RegistrationException ex) {
		response.setMessage(ex.getMessage());
		response.setStatus(401);
		response.setData(null);
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Response> userNotFoundException(UserNotFoundException e) {
		response.setMessage(e.getMessage());
		response.setStatus(401);
		response.setData(null);
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentNotSuccessful.class)
	public ResponseEntity<Response> paymentNotSuccessful(PaymentNotSuccessful e) {
		response.setMessage(e.getMessage());
		response.setStatus(401);
		response.setData(null);
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}
}
