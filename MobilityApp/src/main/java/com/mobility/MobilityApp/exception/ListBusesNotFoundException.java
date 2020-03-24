package com.mobility.MobilityApp.exception;

public class ListBusesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6565828614650409943L;

	public ListBusesNotFoundException() {
	}

	public ListBusesNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListBusesNotFoundException(String message) {
		super(message);
	}

	public ListBusesNotFoundException(Throwable cause) {
		super(cause);
	}
}
