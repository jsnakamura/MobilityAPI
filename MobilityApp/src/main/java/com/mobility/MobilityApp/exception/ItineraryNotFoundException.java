package com.mobility.MobilityApp.exception;

public class ItineraryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4605717946387792319L;

	public ItineraryNotFoundException() {
	}

	public ItineraryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItineraryNotFoundException(String message) {
		super(message);
	}

	public ItineraryNotFoundException(Throwable cause) {
		super(cause);
	}
}
