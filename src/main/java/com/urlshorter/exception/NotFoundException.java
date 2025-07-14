package com.urlshorter.exception;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String Message) {
		super(Message);
	}
}
