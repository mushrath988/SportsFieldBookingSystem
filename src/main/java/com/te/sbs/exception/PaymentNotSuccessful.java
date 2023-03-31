package com.te.sbs.exception;

@SuppressWarnings("serial")
public class PaymentNotSuccessful extends RuntimeException {
	
	public PaymentNotSuccessful(String message, Integer id) {
			super(message);
	}
}
