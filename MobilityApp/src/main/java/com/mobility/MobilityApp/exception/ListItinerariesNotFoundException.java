package com.mobility.MobilityApp.exception;

public class ListItinerariesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7371465643220859030L;

	public ListItinerariesNotFoundException() {
	}

	public ListItinerariesNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListItinerariesNotFoundException(String message) {
		super(message);
	}

	public ListItinerariesNotFoundException(Throwable cause) {
		super(cause);
	}
}
