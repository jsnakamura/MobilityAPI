package com.mobility.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobilityErrorResponse {

	private int status;
	private String message;
	private long timeStamp;
}
