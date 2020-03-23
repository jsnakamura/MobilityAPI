package com.mobility.exception;

public class BusNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2858176262299738947L;

	public BusNotFoundException() {
	}

	public BusNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusNotFoundException(String message) {
		super(message);
	}

	public BusNotFoundException(Throwable cause) {
		super(cause);
	}

}
